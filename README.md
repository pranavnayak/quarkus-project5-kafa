# quarkus-project5-kafa
 A Sample Java MicroProfile Microservice Application in RedHat Quarkus demonstrating Reactive Messaging to interact with Apache Kafka.

# Running 
Starts Apache Kafka and ZooKeeper via Docker Compose via docker-compose-local.yaml,changing the value of the KAFKA_ADVERTISED_LISTENERS variable so it contains your host machine's name or ip address. Then run:

docker-compose -f docker-compose-local.yaml up

Then Run the producer application followed by consumer application.

Then, open your browser at http://localhost:8080/quotes.html. You can send quote requests and observe received quotes.
