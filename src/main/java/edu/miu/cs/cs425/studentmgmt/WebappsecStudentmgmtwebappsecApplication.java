package edu.miu.cs.cs425.studentmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WebappsecStudentmgmtwebappsecApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappsecStudentmgmtwebappsecApplication.class, args);
    }

}
