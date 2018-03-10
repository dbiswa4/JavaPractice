package com.java.ms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fan4DataFormat_1 {

	public static void main(String[] args) throws IOException {

		// File fileRead = new File("cleanedupFan4_network_analysis_1.txt");
		// File fileWrite = new File("cleanedupFan4_nw_inverted.txt");

		File fileRead = new File("cleanedupFan4_nw_analysis_combined.txt");
		File fileWrite = new File(
				"cleanedupFan4_nw_analysis_combined_inverted.txt");

		BufferedReader brRead = null;
		BufferedWriter brWrite = null;

		double sumDouble = 0.0;

		try {
			FileReader frRead = new FileReader(fileRead);
			brRead = new BufferedReader(frRead);

			FileWriter frWrite = new FileWriter(fileWrite);
			brWrite = new BufferedWriter(frWrite);

			String line;

			Map<String, List<String>> map = new HashMap<String, List<String>>();

			while ((line = brRead.readLine()) != null) {

				System.out.println("line : " + line.toString());
				String[] strArray = line.split(",");

				String issueNo = strArray[0];
				System.out.println("strArray[0] : " + strArray[0]);
				
				if (strArray.length >= 2) {

					String fanName = strArray[1];

					if (map.containsKey(issueNo)) {
						List<String> list = map.get(issueNo);
						list.add(fanName);
					} else {
						List<String> list = new ArrayList<String>();
						list.add(fanName);
						map.put(issueNo, list);
					}
				}

			}

			for (Map.Entry<String, List<String>> val : map.entrySet()) {

				StringBuilder sb = new StringBuilder();
				String joinedName = listToString(val.getValue(), "|");

				sb.append(val.getKey()).append(",").append(joinedName);

				brWrite.write(sb.toString());
				brWrite.newLine();

			}

			System.out.println("Sum of PageRankValue : "
					+ (new BigDecimal(sumDouble)));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		finally {
			brRead.close();
			brWrite.close();
		}

	}

	public static String listToString(List<String> inputList, String colSep) {

		if (inputList.size() != 0) {
			StringBuilder sb = new StringBuilder();

			for (String element : inputList) {
				if (!element.isEmpty() || element != null) {
					sb.append(element).append(colSep);
				}

			}

			return sb.toString().substring(0, sb.length() - 1);
		} else {
			return null;
		}

	}

}
