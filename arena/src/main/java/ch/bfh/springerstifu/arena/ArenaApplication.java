package ch.bfh.springerstifu.arena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class ArenaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArenaApplication.class, args);
	}
}
