package com.ceiba.mercapulgas.cache;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.ceiba.mercapulgas.dominio.Productos;
import com.ceiba.mercapulgas.dominio.ProductosCache;


@Component
public class Cache {

	private static  String key = "";
	private RedisTemplate<String, Page<Productos>> redisTemplate;
	private HashOperations hashOperations;
	
	public Cache(RedisTemplate<String, Page<Productos>> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	
	public void setKey(String key) {
		this.key = key;
	}
	
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}


	public Map<String, Page<Productos>>   findAll() {
		return  hashOperations.entries(key);
	}


	public void save(Page<Productos> productos) {
		hashOperations.put(key, UUID.randomUUID().toString(), productos);
		
	}
}
