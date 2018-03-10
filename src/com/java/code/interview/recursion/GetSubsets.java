package com.java.code.interview.recursion;

/***************************************************************************************************
 * 
 * Input : [1,2,3]
 * Output:
 *[]
 [3]
 [2]
 [3, 2]
 [1]
 [3, 1]
 [2, 1]
 [3, 2, 1]
 * 
 * 
 ***************************************************************************************************/

import java.util.ArrayList;
import java.util.List;

public class GetSubsets {

	public static void main(String[] args) {

		ArrayList<Integer> test = new ArrayList<Integer>();

		test.add(1);
		test.add(2);
		//test.add(3);

		List<ArrayList<Integer>> output = getSubsets(test, 0);

		for (ArrayList<Integer> set : output) {

			System.out.println(set.toString());

		}

	}

	public static ArrayList<ArrayList<Integer>> getSubsets(
			ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

}
