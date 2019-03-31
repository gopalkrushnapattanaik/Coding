# Coding Practice

``` This Repository has created for practice and learning purpose of java ... through Data structures using Java , GoF design patterns and some advanced Java concepts from Java8 and Java9```


### https://github.com/careercup/CtCI-6th-Edition/tree/master/Java



```KAFKA SETUP FOR RUNNING THE DEMO PROJECT SPRING-KAFKA```

```
1.Download Kafka
2.tar -xzf kafka_2.11-1.1.0.tgz
3.cd kafka_2.11-1.1.0
4.Run Zookeeper
  bin/zookeeper-server-start.sh config/zookeeper.properties
5.Run Kafka Broker
  bin/kafka-server-start.sh config/server.properties
6.Create Topic test
  bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
7.Create Topic user
  bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic user
8.Create Producer to produce message to above topic test
  bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
9.Create Consumer to consume message from above topic test
  bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
  
  ```
  
