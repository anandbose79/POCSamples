package com.hcsc.poc.redis.repo;


import org.springframework.stereotype.Repository;

import com.hcsc.poc.redis.models.ExampleData;
import com.hcsc.redislib.RCacheEvict;
import com.hcsc.redislib.RCacheGet;
import com.hcsc.redislib.RCachePut;

@Repository
public class DataRepo {

	
	@RCachePut(cacheName = "test", key = "#data.cachekey" , ttl="#redis.ttl.test")
	public ExampleData cacheData(ExampleData data)
	{

		return data;
	}
	
	@RCacheGet(cacheName = "test",key = "key")
	public ExampleData fetchData(String key)
	{

		return null;

	}
	
	@RCacheEvict(cacheName = "test" , scope = "KEY" , key ="testkey")
	public void delKey(String testkey)
	{
	}
	@RCacheEvict(cacheName = "test" , scope = "ALL" )
	public void delAllKeys()
	{
	}	
	
}
