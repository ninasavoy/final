package br.insper.finalzambom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FinalZambomApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalZambomApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}
}
