package hello;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class GreetingController {
	@CrossOrigin
	@GetMapping(value="/person", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<String> getFlx(){
		ArrayList<String> lst=new ArrayList(Arrays.asList("Person 1","Person 2","Person 3","Person 4","Person 5","Person 6","Person 7","Person 8","Person 9","Person 10"));
		return Flux.fromIterable(lst).log()
				.delayElements(Duration.ofMillis(2000));
	}
	
    @CrossOrigin
    @GetMapping("/events/{id}")
    public Mono<Event> eventById(@PathVariable long id) {
        return Mono.just(new Event(id, LocalDate.now()));
    }

    @CrossOrigin
    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Event> events() {
        Flux<Event> eventFlux = Flux.fromStream(
            Stream.generate(
                ()->new Event(System.currentTimeMillis(), LocalDate.now()))
            );

        Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));

        return Flux.zip(eventFlux, durationFlux).map(Tuple2::getT1);
    }
	
}
