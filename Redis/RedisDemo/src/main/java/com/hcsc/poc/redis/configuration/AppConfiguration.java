package com.hcsc.poc.redis.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="appprops")

public class AppConfiguration {
	public List<String> redisnodes;

	public List<String> getRedisnodes() {
		return redisnodes;
	}

	public void setRedisnodes(List<String> redisnodes) {
		this.redisnodes = redisnodes;
	}
	

}
