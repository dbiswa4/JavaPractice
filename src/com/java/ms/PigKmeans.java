/*
 * Software License, Version 1.0
 *
 *  Copyright 2003 The Trustees of Indiana University.  All rights reserved.
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1) All redistributions of source code must retain the above copyright notice,
 *  the list of authors in the original source code, this list of conditions and
 *  the disclaimer listed in this license;
 * 2) All redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the disclaimer listed in this license in
 *  the documentation and/or other materials provided with the distribution;
 * 3) Any documentation included with all redistributions must include the
 *  following acknowledgement:
 *
 * "This product includes software developed by the Community Grids Lab. For
 *  further information contact the Community Grids Lab at
 *  http://communitygrids.iu.edu/."
 *
 *  Alternatively, this acknowledgement may appear in the software itself, and
 *  wherever such third-party acknowledgments normally appear.
 *
 * 4) The name Indiana University or Community Grids Lab or Twister,
 *  shall not be used to endorse or promote products derived from this software
 *  without prior written permission from Indiana University.  For written
 *  permission, please contact the Advanced Research and Technology Institute
 *  ("ARTI") at 351 West 10th Street, Indianapolis, Indiana 46202.
 * 5) Products derived from this software may not be called Twister,
 *  nor may Indiana University or Community Grids Lab or Twister appear
 *  in their name, without prior written permission of ARTI.
 *
 *
 *  Indiana University provides no reassurances that the source code provided
 *  does not infringe the patent or any other intellectual property rights of
 *  any other entity.  Indiana University disclaims any liability to any
 *  recipient for claims brought by any other entity based on infringement of
 *  intellectual property rights or otherwise.
 *
 * LICENSEE UNDERSTANDS THAT SOFTWARE IS PROVIDED "AS IS" FOR WHICH NO
 * WARRANTIES AS TO CAPABILITIES OR ACCURACY ARE MADE. INDIANA UNIVERSITY GIVES
 * NO WARRANTIES AND MAKES NO REPRESENTATION THAT SOFTWARE IS FREE OF
 * INFRINGEMENT OF THIRD PARTY PATENT, COPYRIGHT, OR OTHER PROPRIETARY RIGHTS.
 * INDIANA UNIVERSITY MAKES NO WARRANTIES THAT SOFTWARE IS FREE FROM "BUGS",
 * "VIRUSES", "TROJAN HORSES", "TRAP DOORS", "WORMS", OR OTHER HARMFUL CODE.
 * LICENSEE ASSUMES THE ENTIRE RISK AS TO THE PERFORMANCE OF SOFTWARE AND/OR
 * ASSOCIATED MATERIALS, AND TO THE PERFORMANCE AND VALIDITY OF INFORMATION
 * GENERATED USING SOFTWARE.
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.pig.LoadFunc;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.PigSplit;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.impl.util.UDFContext;

/**
 * taklwu
 * Feb 6, 2014
 */

/**
 *  Pig data loader for binary array datapoints for kmeans
 *  This class extends Pig's default @see org.apache.pig.LoadFunc
 *  which 
 *  1. loads files from a given HDFS directory into data points arrary
 *  2. find the centriods for all data points, and store it as a double [][] array
 *  3. convert the double [][] array into Pig databag in a single Tuple
 *  
 **/

public class PigKmeans extends LoadFunc {
	
	private RecordReader reader;
    private TupleFactory tupleFactory;
    protected final Log log = LogFactory.getLog(getClass());
    private int dimension = 4;
    private Configuration jc;
    private int numOfCentroids;
	private double[][] centroids;
	
	// 1. don't use primitive datatype Double, use double instead
	// 2. close file after reading
	// 3. read data and do calculation at the same time
	// 4. less intermediate data	
 
    public PigKmeans() {
        tupleFactory = TupleFactory.getInstance();
    }
    
    public PigKmeans(String initialCentroidFilePath, String numOfCentroids) {    	
    	log.info("Starting loading centriods = " + System.currentTimeMillis());
        tupleFactory = TupleFactory.getInstance();
        this.numOfCentroids = Integer.valueOf(numOfCentroids);
		this.loadDistributedCachedCentroids(initialCentroidFilePath);
        log.info("End of loading centriods = " + System.currentTimeMillis());
        log.info("Finished loading centriods " + this.centroids.length);
        log.info("Dimension " + this.dimension);
    }
 
    @Override
    public InputFormat getInputFormat() throws IOException {
        return new FilePathInputFormat();
    }
 
    /**
     * Each tuple will like {(w, x, y, z)}.
     * (non-Javadoc)
     * @see org.apache.pig.LoadFunc#getNext()
     **/
    @Override
    public Tuple getNext() throws IOException {
        Tuple tuple = tupleFactory.newTuple(1);
        log.warn("Start of getNext()  = " + System.currentTimeMillis());
        double[][] newTmpCentroids = new double[this.numOfCentroids][this.dimension];
        for (int i =0; i < this.numOfCentroids; i++) 
        	for (int j=0; j < this.dimension;j++)
        		newTmpCentroids[i][j]=0.0;
        
        int numOfPoints = 0;
        Path file = null;
        ArrayList<double[]> dataPoints = new ArrayList<double[]>();
        try {
            boolean notDone = reader.nextKeyValue();
            if (!notDone) {
                return null;
            }

            file = (Path) reader.getCurrentKey();
            Configuration jc = UDFContext.getUDFContext().getJobConf();
            
	    		long startReading = System.currentTimeMillis();
	            log.info(file.toString() + " start reading, the current time = " + startReading);
	            InputStream dataPointsFile = FileSystem.get(jc).open(file);
	            DataInputStream input = new DataInputStream(dataPointsFile);
	            double[] newDataPoint = new double[dimension];
	    		// read data points into ArrayList
	    		while ( input.available() > 0) {
	    			newDataPoint = new double[dimension];
			        for (int i = 0; i < dimension-1; i++) {
			        	newDataPoint[i] = input.readDouble();
			        }
			        newDataPoint[dimension-1] = 0.0;
			        dataPoints.add(newDataPoint);
			        numOfPoints++;
	    		}
	    		input.close();
	    		double[][] dataPointsInArray = new double[numOfPoints][this.dimension];
	    		dataPointsInArray = dataPoints.toArray(dataPointsInArray);
	    		// read all data points
	    		log.warn(file.toString() + " End reading the data time = " + System.currentTimeMillis());
	    		
	    		// find centriod for each data points
	    		newTmpCentroids = this.findClosestCentroids(this.centroids, dataPointsInArray);
	        	
	    		// make the output centroids vector as a databg in Tuple
	    		tuple = this.makeNewOutputTuple(newTmpCentroids);
	    			
    	} catch (EOFException e) {
    		log.warn("EOF " + file + ", " + numOfPoints);
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            
        log.warn("End of getNext()  = " + System.currentTimeMillis());
        return tuple;
    }
 
    @Override
    public void prepareToRead(RecordReader reader, PigSplit pigSplit)
            throws IOException {
        this.reader = reader;
    }
 
    @Override
    public void setLocation(String location, Job job) throws IOException {
        FileInputFormat.setInputPaths(job, location);
    }
    
    /**
     * TODO write your own code for looking the closest centroid for a set of data points 
     * @param Centroids, centroid from last iteration
     * @param newTmpCentroids, temporarily centroids for this partiton of data points
     * @param dataPoints, , this partiton of data points
     * @return newTmpCentroids
     * @throws ExecException
     */
    public double[][] findClosestCentroids(double[][] Centroids, double[][] dataPoints) throws ExecException {
    	long startTime = System.currentTimeMillis();
    	log.info("findClosestCentroids start = " + startTime);
        int comCount = 0; 
        double[][] newTmpCentroids = new double[this.numOfCentroids][this.dimension];
        int[] cCounts = new int[this.numOfCentroids];
        
    	for (int i = 0 ; i < dataPoints.length; i++  ) {
    	    // TODO write your own code to find the closest centroid for each data point
    	    // hints
    	    // 1. dataPoints is parsed data point in double[][] format
    	    // 2. loop through double[][] Centroids, calculate the Euclidean distance by using getEuclideanDistance
    	    // 3. if this is the smallest distance, mark it down as closest centroid
    	    // 4. Update the assigned Centroid (newTmpCentroids[closest_centroid]) by accumlating coordinate value of each dimension of that data Point
    	    // 5. Use the last slot of newTmpCentroids, e.g. newTmpCentroids[closest_centroid][this.dimension-1], to store the assoicated data points count of this centroid
    	        		
    		double shortestDist = 0.0;
    		  int closest_centroid = 0;
    		   
    		  for(int j = 0; j < Centroids.length; j++ ) {
    		   
    		  double testDist = getEuclideanDistance(dataPoints[i],Centroids[j]);
    		  
    		  if(j == 0) { shortestDist = testDist; closest_centroid = 0;}
    		  if (testDist < shortestDist) {shortestDist = testDist; closest_centroid = j;}
    		  }
    		   
    		  for (int k=0; k < this.dimension-1; k++)
    		  newTmpCentroids[closest_centroid][k] = newTmpCentroids[closest_centroid][k] + dataPoints[i][k];
    		   
    		  newTmpCentroids[closest_centroid][this.dimension-1] = newTmpCentroids[closest_centroid][this.dimension-1] + 1;  
    		  }
    		   
    		  for (int k=0; k < this.dimension-1; k++)
    		  newTmpCentroids[closest_centroid][k] = newTmpCentroids[closest_centroid][k] / newTmpCentroids[closest_centroid][this.dimension-1];
    		   
    		  newTmpCentroids[closest_centroid][this.dimension-1] = 1;
    		   
    		  long endTime = System.currentTimeMillis();
    	}
    	long endTime = System.currentTimeMillis();
    	log.info("total computed Euclidean distance = " + comCount);
    	log.info("findClosestCentroids end = " + endTime);
		return newTmpCentroids;
    }
    
    public Tuple makeNewOutputTuple (double[][] newTmpCentroids) throws ExecException {
    	log.warn("makeNewOutputTuple start = " + System.currentTimeMillis());
    	Tuple tuple =tupleFactory.newTuple(1);
    	DataBag dataBag =  BagFactory.getInstance().newDefaultBag();
    	Tuple t =tupleFactory.newTuple(1);
    	String dataPointInString = "";
    	for (int i = 0; i < this.numOfCentroids; i++ ) {
    		t =tupleFactory.newTuple(1);
    		dataPointInString = this.dataPointToString(newTmpCentroids[i], this.dimension);
    		t.set(0, i+","+dataPointInString);
    		dataBag.add(t);
    	}
    	tuple.set(0, dataBag);
    	log.warn("makeNewOutputTuple end = " + System.currentTimeMillis());
    	return tuple;
    }
    
    public String dataPointToString(double[] dataPoint, int dimension) {
    	// x,y,z,count
    	String result = "";
    	for (int i = 0; i < dimension; i++) {
    		if (i < dimension-1)
    			result += String.valueOf(dataPoint[i]) + ",";
			else
				result += String.valueOf(dataPoint[i]);
    	}
    	return result;
    }
    
	public double getEuclideanDistance(double[] v1, double[] v2) {
		double sum = 0;
		for (int i = 0; i < this.dimension-1; i++) {
			sum += ((v1[i] - v2[i]) * (v1[i] - v2[i]));
		}
		return sum;
	}
	
	public void printCentroids() {
		String result = "";
    	for (double[] dataPoint: centroids) {
            for (int j=0 ; j<3; j++) {
            	if (j < 2)
            		result += String.valueOf(dataPoint[j]) + ",";
            	else
            		result += String.valueOf(dataPoint[j]);	
            }
            log.warn("centroid = " + result);
    	}
	}

	public void loadDistributedCachedCentroids(String filePath)  {
		FileReader fr;
		try {
			fr = new FileReader(filePath);
			BufferedReader d = new BufferedReader(fr);
			centroids = new double[numOfCentroids][this.dimension];
			// this is a static number of reading, it could be dynamic
			for (int i = 0; i < numOfCentroids; i++) {
				String[] datapoints = d.readLine().split(" ");
				for (int j = 0; j < this.dimension-1; j++) {
					centroids[i][j] = Double.parseDouble(datapoints[j]);
				}
				centroids[i][this.dimension-1] = 0.0;
			}
			d.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(255);
		} catch (IOException e) {
			// error when there is any empty buffer 
			return;
		}
	}

}
