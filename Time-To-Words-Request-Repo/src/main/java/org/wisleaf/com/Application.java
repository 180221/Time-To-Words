package org.wisleaf.com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = "org.wisleaf.com")
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
    }
}
