package ch.bfh.springerstifu.promoter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class PromoterApplication {
	public static void main(String[] args) {
		SpringApplication.run(PromoterApplication.class, args);
	}
}
