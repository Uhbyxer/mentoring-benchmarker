package com.mentoring.benchmarker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MemoryBenchmark {
	public static long SIZE = 10000;
	
	public static void main(String[] args) {
		System.out.println("List memory benchmarking:");
		System.out.println("Capacity: " + SIZE);
		
		List<Integer> linkedList = new LinkedList<Integer>();
		listSizeBenchmark(linkedList);
		
		
		List<Integer> arrayList = new ArrayList<Integer>();
		listSizeBenchmark(arrayList);
		
		


		Multiset<Integer> multiset = HashMultiset.create();
		multiSetSizeBenchmark(multiset);
		
		Map<Integer, Integer> hashMap =  new HashMap<>();
		hashMapSizeBenchmark(hashMap);
		
		

	}
	
	@Override
	protected void finalize() throws Throwable {
		System.err.println("gc works...");
		super.finalize();
	}
	
	public static void listSizeBenchmark(List<Integer> list) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + list.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			list.add(i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));
		
	}
	
	public static void hashMapSizeBenchmark(Map<Integer, Integer> map) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + map.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			map.put(i, i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));
		
	}
	
	public static void multiSetSizeBenchmark(Multiset<Integer> multiset) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + multiset.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			multiset.add(i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));
		
	}
	
	
}
