package com.barber.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 不加这个注解的话, 使用@Autowired 就不能注入进去了
@ConfigurationProperties(prefix = "my")
// 配置文件中的前缀
public class MyConfig {

	private String redisFirstKey;
	private String redisSecondKey;
	private Integer redisTimeOut;

	
	
	public MyConfig() {
		super();
	}



	public String getRedisFirstKey() {
		return redisFirstKey;
	}



	public void setRedisFirstKey(String redisFirstKey) {
		this.redisFirstKey = redisFirstKey;
	}



	public String getRedisSecondKey() {
		return redisSecondKey;
	}



	public void setRedisSecondKey(String redisSecondKey) {
		this.redisSecondKey = redisSecondKey;
	}



	public Integer getRedisTimeOut() {
		return redisTimeOut;
	}



	public void setRedisTimeOut(Integer redisTimeOut) {
		this.redisTimeOut = redisTimeOut;
	}

	
}
