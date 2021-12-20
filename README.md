# quarkus-project5-kafa
 A Sample Java MicroProfile Microservice Application in RedHat Quarkus demonstrating Reactive Messaging to interact with Apache Kafka.

# Running the sample application
Start Apache Kafka and ZooKeeper via Docker Compose via docker-compose-local.yaml,changing the value of the KAFKA_ADVERTISED_LISTENERS variable so it contains your host machine's name or ip address. Then run:

docker-compose -f docker-compose-local.yaml up

Then Run the producer application followed by consumer application.

Then, open your browser at http://localhost:8080/quotes.html. You can send quote requests and observe received quotes.

# Verification in Kafka Topic

Run  docker ps on the machine where kafa is running and get the container name. then run  "docker exec -it kafka_kafka_1  /bin/bash" to enter bash of the kafka container.

Run the commands to view messages produced/consumed form both the topics used in the application.

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic quote-requests --from-beginning
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic quotes --from-beginning

![This is an image](https://github.com/pranavnayak/quarkus-project5-kafa/blob/main/Capture.JPG)

# Application Info
The sample project has two applications communicating via Kafka. 

quarkus-project5-kafka1-producer application lets the user request some quotes over a HTTP endpoint http://localhost:8080/quotes.html. For each quote request a random identifier is generated and returned to the user, to mark the quote request as pending. At the same time, the generated request id is sent over a Kafka topic "quote-requests".


quarkus-project5-kafka1-consumer will read from the quote-requests topic, put a random price to the quote, and send it to a Kafka topic named "quotes".

quarkus-project5-kafka1-producer will then read the quotes and send them to the browser using server-sent events. The user will therefore see the quote price updated from pending to the received price in real-time.

![This is an image](https://github.com/pranavnayak/quarkus-project5-kafa/blob/main/Flow%20DIagram.jpg)

![This is an image](https://github.com/pranavnayak/quarkus-project5-kafa/blob/main/2.JPG)
 
