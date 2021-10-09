package com.tuyennguyen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebBanHangApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SpringWebBanHangApplication.class);
        logger.info("----");
        logger.info("SpringApplication Started");
        SpringApplication.run(SpringWebBanHangApplication.class, args);
    }

}
