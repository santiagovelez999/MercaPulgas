package com.ceiba.mercapulgas.cache;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.ceiba.mercapulgas.dominio.Productos;
import com.ceiba.mercapulgas.dominio.ProductosCache;


@Configuration
public class ConfiguracionCache {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	   return new JedisConnectionFactory();
	} 
	
	@Bean
	public RedisTemplate<String, Page<Productos>> redisTemplate() {
	    RedisTemplate<String, Page<Productos>> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}
}
