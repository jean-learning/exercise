sudo docker-compose up
sudo docker exec -it 41103149fbbf mysql -uroot -proot

use students_db;
show tables;
create table students(id varchar(100) not null, name varchar(100) not null, age integer not null);


./kaftopics.sh --list --zookeeper localhost:2181
jean@jean-VirtualBox:~/app/kafka_2.13-2.7.0/bin$ ./kafka-console-producer.sh --topic sample-events --bootstrap-server localhost:9092

./kafka-console-consumer.sh --topic sample-events --from-beginning --bootstrap-server localhost:9092




bin/zookeeper-server-start.sh config/zookeeper.properties
