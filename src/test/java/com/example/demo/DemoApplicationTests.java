package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void verify_getHello() {
        ResponseEntity<String> helloResponse = restTemplate.getForEntity("/api/v1/hello", String.class);
        assertThat(helloResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(helloResponse.getBody()).isEqualTo("hello");
    }


}
