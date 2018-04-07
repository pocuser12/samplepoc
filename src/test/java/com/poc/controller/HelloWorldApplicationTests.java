package com.poc.controller;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;

/**
 * Basic integration tests for service demo application.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class HelloWorldApplicationTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/helloWorld", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	

	 
	@Test
	public void shouldReturn200WhenSendingRequestToControllerForDetails() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/helloWorld/detail", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	
	@Test
	public void shouldReturn200WhenSendingRequestToControllerForFibonacci() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/helloWorld/fibonacci/10", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
}
