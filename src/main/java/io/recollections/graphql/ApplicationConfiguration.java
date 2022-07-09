package io.recollections.graphql;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@EnableReactiveMongoRepositories
public class ApplicationConfiguration extends AbstractReactiveMongoConfiguration {

  @Override
  protected String getDatabaseName() {
    return "greetings";
  }

  @Override
  public MongoClient reactiveMongoClient() {
    return MongoClients.create();
  }
}
