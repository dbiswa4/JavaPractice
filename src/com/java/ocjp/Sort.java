package com.java.ocjp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Sort {

	public static void main(String[] args) {
		
		HashMap props = new HashMap();
		props.put("key45", "some value");
		props.put("key12", "some other value");
		props.put("key39", "yet another value");
		
		Set s = props.keySet();		
		s = new TreeSet<>(s);
		
		Iterator itr = s.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//Collections.sort(s);

	}

}
