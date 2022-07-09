package io.recollections.graphql;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import io.recollections.graphql.entities.Greeting;
import reactor.core.publisher.Flux;

public interface ReactiveGreetingRepository extends ReactiveSortingRepository<Greeting, String> {

  Flux<Greeting> findByType(String type);
}
