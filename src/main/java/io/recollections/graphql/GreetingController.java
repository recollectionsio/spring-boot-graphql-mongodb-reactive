/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.recollections.graphql;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

  @Autowired
  ReactiveGreetingRepository repository;

  public GreetingController(ReactiveGreetingRepository repository) {
    this.repository = repository;
  }

  @QueryMapping
  public Mono<String> greeting() {
    Mono<String> response =
        this.repository.findByType("Greeting").next().map(g -> g.getGreeting().get(0));
    return response;
  }

  @QueryMapping
  public Flux<String> greetings() {
    return this.repository.findByType("Greetings").concatMapIterable(g -> g.getGreeting());
  }

  @SubscriptionMapping
  public Flux<String> greetingsSubscription() {
    return greetings();
  }

}
