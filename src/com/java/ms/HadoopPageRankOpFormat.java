package com.java.ms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class HadoopPageRankOpFormat {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
		File fileRead = new File("part-r-00000_r4");
		File fileWrite = new File("part-r-00000_r4_format_2");
		
		BufferedReader brRead = null;
		BufferedWriter brWrite = null;
		
		double sumDouble = 0.0;
		
		try {
			FileReader frRead = new FileReader(fileRead);
			brRead = new BufferedReader(frRead);
			
			FileWriter frWrite = new FileWriter(fileWrite);
			brWrite = new BufferedWriter(frWrite);
			
			
			String line;
			
			while((line = brRead.readLine()) != null) {
				
				String[] strArray = line.split("\\t");
				
				BigDecimal bd = new BigDecimal(Double.valueOf(strArray[1]));
				sumDouble = sumDouble + Double.valueOf(strArray[1]);
				
				StringBuffer sb = new StringBuffer();
				sb.append(strArray[0]).append("\t").append(bd);
				brWrite.write(sb.toString());	
				brWrite.newLine();
				
			}
			
			System.out.println("Sum of PageRankValue : " +(new BigDecimal(sumDouble)) );
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		finally {
			brRead.close();
			brWrite.close();
		}

	}

}
