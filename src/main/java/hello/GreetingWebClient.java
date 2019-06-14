package hello;

import java.lang.reflect.Array;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GreetingWebClient {
	private WebClient client = WebClient.create("http://localhost:8080");


	private WebClient.ResponseSpec resultP = client.get()
			.uri("/person")
			.accept(MediaType.ALL)
			.retrieve();

	
	public void getResultPerson() {
		resultP.bodyToFlux(String.class).subscribe(System.out::println);
	}
}
