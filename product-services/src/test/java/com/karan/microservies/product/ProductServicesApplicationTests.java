package com.karan.microservies.product;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.shaded.org.hamcrest.Matchers;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServicesApplicationTests {

	@Autowired
	MongoDBContainer mongoDbContainer;

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	// static {
	// 	mongoDbContainer.start();
	// }

	// @Test
	// void contextLoads() {
	// 	String requestBody = """
				
	// 			""";

	// 	RestAssured.given()
	// 		.contentType("application/json")
	// 		.body(requestBody)
	// 		.when()
	// 		.post("/api/product")
	// 		.then()
	// 		.statusCode(201)
	// 		.body("id",Matchers.notNullValue())
	// 		.body("name", Matchers.equalTo("iPhone 15"))
	// 		.body("description", Matchers.equalTo("iPhone 15 is a smartphone from Apple"))
	// 		.body("price", Matchers.equalTo(1000));
	// }

}
