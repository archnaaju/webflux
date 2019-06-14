package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		GreetingWebClient gwc = new GreetingWebClient();
		
		long start=System.currentTimeMillis();
		System.out.println("Before!!!!!!!!!");
		gwc.getResultPerson();		
		System.out.println("Next!!!!!!!!!");

	}
}
