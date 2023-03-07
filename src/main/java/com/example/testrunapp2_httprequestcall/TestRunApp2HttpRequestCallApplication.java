package com.example.testrunapp2_httprequestcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class TestRunApp2HttpRequestCallApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRunApp2HttpRequestCallApplication.class, args);

        generateHttpGetRequest("http://localhost:8082/hello");

        try {
            Thread.sleep(5000); // 5 seconds
        } catch(InterruptedException e) {
            log.error(e.getMessage());
//            throw new RuntimeException(e);
        }

        System.out.println("------------프로그램 정상 종료------------");
        System.exit(0);
    }


    private static void generateHttpGetRequest(String url) { // "http://localhost:8082/hello"  주소로 http 요청 보내기
        RestTemplate ret = new RestTemplate();
        ResponseEntity<String> res = ret.getForEntity(url, String.class);

        log.info("");
        log.info("===================================");
        log.info("[headers] " + res.getHeaders());
        log.info("[statusCode] " + res.getStatusCode());
        log.info("[body] " + res.getBody());
        log.info("===================================");
        log.info("");
    }

}
