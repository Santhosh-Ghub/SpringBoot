package com.example.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommunicationService {
	@Value("${external.api.url}")
	private String extUrl;

	@Autowired
	RestTemplate restTemplate;
	
	public String communicationGet(String name) {
		String url=extUrl+name;
		return restTemplate.getForObject(url, String.class);
	}
	public String communicationPost(String name, String department) {
		String url=extUrl+name;
		return restTemplate.postForObject(url, department,String.class);
	}
}