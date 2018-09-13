# practice

``` This Repository has created for practice and learning purpose of java ... through Data structures using Java , GoF design patterns and some advanced Java concepts from Java8 and Java9```


KAFKA SETUP FOR RUNNING THE DEMO

1.Download Kafka
2.tar -xzf kafka_2.11-1.1.0.tgz
3.cd kafka_2.11-1.1.0
4.Run Zookeeper
  bin/zookeeper-server-start.sh config/zookeeper.properties
5.Run Kafka Broker
  bin/kafka-server-start.sh config/server.properties
6.Create Topic
  bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
7.Create Producer to produce message to above topic
  bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
8.Create Consumer to consume message from above topic
  bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
  
