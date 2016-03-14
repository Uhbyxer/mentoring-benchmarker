package com.mentoring.benchmarker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;

public class MemoryBenchmark {
	public static long SIZE = 10000;
	
	public static void main(String[] args) {
		System.out.println("List memory benchmarking:");
		System.out.println("Capacity: " + SIZE);
		
//		List<Integer> linkedList = new LinkedList<Integer>();
//		listSizeBenchmark(linkedList);
//		
//		
//		List<Integer> arrayList = new ArrayList<Integer>();
//		listSizeBenchmark(arrayList);
		
		
		Map<Integer, Integer> hashMap =  new HashMap<>();
		hashMapSizeBenchmark(hashMap);

		Multiset<Integer> multiset = HashMultiset.create();
		multiSetSizeBenchmark(multiset);
		
		
		Multimap<Integer, Integer> multimap = HashMultimap.create();
		multiMapSizeBenchmark(multimap);
		
		BiMap<Integer, Integer> biMap = HashBiMap.create();
		biMapSizeBenchmark(biMap);
		
		Table<Integer, Integer, Integer> table = HashBasedTable.create();
		tableSizeBenchmark(table);
		
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
	
	private static void multiMapSizeBenchmark(Multimap<Integer, Integer> multimap) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + multimap.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			multimap.put(i,i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));
		
	}
	

	private static void biMapSizeBenchmark(BiMap<Integer, Integer> biMap) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + biMap.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			biMap.put(i,i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));		
	}

	private static void tableSizeBenchmark(Table<Integer, Integer, Integer> biMap) {
		new MemoryBenchmark();
		
		int columns = 100;
		int rows = (int) SIZE / 100;
		
		System.out.println("\nlistSizeBenchmark() -> " + biMap.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; i < columns; j++) {
				biMap.put(i, j, i*j);
			}	
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));		
	}
	
	
}
