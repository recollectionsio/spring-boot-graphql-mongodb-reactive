### **Reactive Spring GraphQL Server with MongoDB**

Demo project implementing reactive [Spring GraphQL](https://docs.spring.io/spring-graphql/docs/current/reference/html/) server that queries [MongoDB](https://www.mongodb.com/try/download/community) using its [reactive driver](https://www.mongodb.com/docs/drivers/reactive-streams/).

### Setup

You'll need a MongoDB instance running on `localhost` at the default **port** of `27017`. 

Create a database `greetings` and a collection `greeting` within the database. Import into the `greeting` collection the data found in [`greetings.json`](./src/main/resources/data/greetings.json) into the 'greeting' collection.

### Running
Now you can run the Spring GraphQL server by running below from the project root:

```
> mvn spring-boot:run
```
From another terminal, run the following curl command to verify everything works:
```
> curl -X POST http://localhost:8080/graphql -d '{"query":"query {\n greetings\n}\n"}' -H 'Content-Type: application/json'
{"data":{"greetings":["Hi","Bonjour","Hola","Ciao","Zdravo"]}}
```
