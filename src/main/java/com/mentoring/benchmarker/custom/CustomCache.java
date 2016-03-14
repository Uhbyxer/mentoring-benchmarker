package com.mentoring.benchmarker.custom;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.EvictingQueue;

public class CustomCache<K, V> extends LinkedHashMap<K, V> {
	private final int capacity;
	
	public CustomCache(int capacity) {
		super(capacity + 1, 1.1f, true);
		
		//super(capacity + 1, 1.1f, false);
		
		this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > capacity;
	}
	
	
	public static void main(String[] args) {
		CustomCache<Integer, Integer> cache = new CustomCache<Integer, Integer>(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		
		cache.get(2);
		
		cache.put(9, 9);
		
		System.out.println(cache);
		
		//*************************************************
		
		List<Integer> holder = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		LoadingCache<Integer, Integer> loadingCache = 
		         CacheBuilder.newBuilder()
		            .maximumSize(2) // maximum 100 records can be cached
		            .expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
		            .build(new CacheLoader<Integer, Integer>() { // build the cacheloader
		            
		               @Override
		               public Integer load(Integer id) throws Exception {
		                  //make the expensive call
		                  return holder.get(id);
		            	   
		               } 
		            });
		
		
		loadingCache.put(1, 1);
		loadingCache.put(2, 2);
		loadingCache.put(3, 3);
		
		loadingCache.getUnchecked(2);

		loadingCache.put(9, 9);
		
		
		System.out.println("loadingCache = ");
		for(int i=0; i<loadingCache.size(); i++) {
			System.out.println(loadingCache.getUnchecked(i));
			
		}
		
		
		
//		Queue<Integer> evictingQueue = EvictingQueue.create(10);
//		for (int i = 1; i <= 15; i++) {
//			evictingQueue.add(i);
//		}
//		
//		System.out.println("evictingQueue: " + evictingQueue);
		
//		Queue<Integer> linkedQueue = new LinkedList<Integer>(10);
//		for (int i = 1; i <= 15; i++) {
//			linkedQueue.add(i);
//		}
//		
//		System.out.println("linkedQueue: " + linkedQueue);		
		
		
		
	}
}
