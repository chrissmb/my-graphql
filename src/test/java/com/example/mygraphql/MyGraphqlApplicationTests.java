package com.example.mygraphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@GraphQLTest
class MyGraphqlApplicationTests {

	@Autowired
	private GraphQLTestTemplate graphQLTestTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetBooks() throws IOException {
		var response = graphQLTestTemplate.postForResource("graphql/getBooks.graphql");
		assertTrue(response.isOk());
	}

	@Test
	void testSaveBook() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode variables = objectMapper.createObjectNode();
		ObjectNode book = objectMapper.createObjectNode();
		book.put("title", "").put("year", 1999);
		variables.put("book", book);
		var response = graphQLTestTemplate
				.perform("graphql/saveBook.graphql", variables);
		assertTrue(response.isOk());
		response.assertThatField("$.errors[0].message")
				.equals("Business exception Title must be filled.");
	}
}
