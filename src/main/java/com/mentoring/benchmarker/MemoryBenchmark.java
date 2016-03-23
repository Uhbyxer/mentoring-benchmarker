package com.mentoring.benchmarker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongArray;

import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.BiMap;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.common.util.concurrent.AtomicLongMap;

public class MemoryBenchmark {
	public static long SIZE = 1000;
	
	public static void main(String[] args) throws Exception {
		System.out.println("List memory benchmarking:");
		System.out.println("Capacity: " + SIZE);
		//System.gc();
		

//		
//		
//		double foo = 0;
//		for(int i=0; i<100000; i++) {
//			foo +=Math.random();
//		}
//		
		
		
		
//		List<Integer> arrayList = new ArrayList<Integer>();
//		listSizeBenchmark(arrayList);
		
		List<Integer> linkedList = new LinkedList<Integer>();
		listSizeBenchmark(linkedList);
		
		//System.out.println(foo);
		


		
		
//		
//		

		

//		Map<Integer, Integer> synchMap = Collections.synchronizedMap(new HashMap<>());
//		hashMapSizeBenchmark(synchMap);
		
		
//		Map<Integer, Integer> hashMap =  new HashMap<>();
//		hashMapSizeBenchmark(hashMap);
//		
//		hashMapGetBenchmark(hashMap);
		

//		Map<Integer, Integer> concurrentHashMap =  new  ConcurrentHashMap<>();
//		hashMapSizeBenchmark(concurrentHashMap);
		

//		ConcurrentSkipListMap<Integer, Integer>  concurrentSkipListMap  =  new ConcurrentSkipListMap<>();
//		concurrentSkipListMapSizeBenchmark(concurrentSkipListMap);

//		Multiset<Integer> multiset = HashMultiset.create();
//		multiSetSizeBenchmark(multiset);
		
//		AtomicLongMap<Integer> atomicMap = AtomicLongMap.create();
//		atomicMapBenchmark(atomicMap);
		
		
//		
//		
//		Multimap<Integer, Integer> multimap = HashMultimap.create();
//		multiMapSizeBenchmark(multimap);
		
		
//		ConcurrentHashMultiset<Integer> concurrentHashMultiset = ConcurrentHashMultiset.create();
//		concurrentHashMultisetSizeBenchmark(concurrentHashMultiset);
		
		
		
//		BiMap<Integer, Integer> biMap = HashBiMap.create();
//		biMapSizeBenchmark(biMap);
		
//		Table<Integer, Integer, Integer> table = HashBasedTable.create();
//		tableSizeBenchmark(table);
		
		
		

		
//		LoadingCache<Integer, Integer> loadingCache = 
//		         CacheBuilder.newBuilder()
//		            .maximumSize(10) // maximum 100 records can be cached
//		            .expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
//		            .build(new CacheLoader<Integer, Integer>() { // build the cacheloader
//		            
//		               @Override
//		               public Integer load(Integer id) throws Exception {
//		                  //make the expensive call
//		                  return id;
//		            	   
//		               } 
//		            });
//		
//		loadingCacheSizeBenchmark(loadingCache);
//		
//		System.out.println("loadingCache = ");
//		for(int i=0; i<loadingCache.size(); i++) {
//			System.out.println(loadingCache.getUnchecked(i));
//			
//		}
		
		
		
	}
	


	@Override
	protected void finalize() throws Throwable {
		System.err.println("gc works...");
		super.finalize();
	}


	
	public static void listSizeBenchmark(List<Integer> list) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + list.getClass().getSimpleName());
		
	
		
		long free =   Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		Stopwatch stopwatch = Stopwatch.createStarted();
		for(int i = 0; i < SIZE; i++) {
			list.add(i);
		}
		
		stopwatch.stop();
		
		freeAfter = Runtime.getRuntime().freeMemory();
		
		long nanos = stopwatch.elapsed(TimeUnit.NANOSECONDS);
		
		
		System.out.println("Used mem: " + (free - freeAfter));
		System.out.println("Nanos: " + nanos + " /" + stopwatch + "/");
		
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
	
	public static void concurrentHashMultisetSizeBenchmark(ConcurrentHashMultiset<Integer> concurrentHashMultiset) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + concurrentHashMultiset.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			concurrentHashMultiset.add(i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));
	}	

	public static void atomicMapBenchmark(AtomicLongMap<Integer> atomicMap) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + atomicMap.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			atomicMap.put(i, i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));
		
	}
	
	public static void multiMapSizeBenchmark(Multimap<Integer, Integer> multimap) {
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
	

	public static void biMapSizeBenchmark(BiMap<Integer, Integer> biMap) {
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

	public static void tableSizeBenchmark(Table<Integer, Integer, Integer> biMap) {
		new MemoryBenchmark();
		
		int columns = 100;
		int rows = (int) SIZE / 100;
		
		System.out.println("\nlistSizeBenchmark() -> " + biMap.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				biMap.put(i, j, i*j);
			}	
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));		
	}
	
	public static void loadingCacheSizeBenchmark(LoadingCache<Integer, Integer> loadingCache) throws ExecutionException {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + loadingCache.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			loadingCache.get(i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));			
	}
	

	public static void concurrentSkipListMapSizeBenchmark(ConcurrentSkipListMap<Integer, Integer> concurrentSkipListMap) {
		new MemoryBenchmark();
		System.out.println("\nlistSizeBenchmark() -> " + concurrentSkipListMap.getClass().getSimpleName());
		long free = Runtime.getRuntime().freeMemory();
		long freeAfter;
		
		for(int i = 0; i < SIZE; i++) {
			concurrentSkipListMap.put(i, i);
		}
		
		freeAfter = Runtime.getRuntime().freeMemory();
		System.out.println("Used mem: " + (free - freeAfter));		
		
	}	
	
	////////////////////////////////////////////////////////////////////
	public static void hashMapGetBenchmark(Map<Integer, Integer> map) {
		new MemoryBenchmark();
		System.out.println("\nMapGetBenchmark() -> " + map.getClass().getSimpleName());
		Integer value = null;
		
		Stopwatch stopwatch = Stopwatch.createStarted();
		for(int i = 0; i < SIZE; i++) {
			value = map.get(i);
		}
		long nanos = stopwatch.elapsed(TimeUnit.NANOSECONDS);
		
		System.out.println("value = " + value);
		System.out.println("Nanos: " + nanos + " /" + stopwatch + "/");
		
	}

	
}
