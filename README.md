# DemoKafkaPostgreSQLElasticsearch

## Summary
This is a demo project to test out the integration of four techonologies: Spring + Kafka + PostgreSQL + Elasticsearch.
The application is quite simple: we have a controller written in Java Spring which contains all the logic and controls related components including Kafka, PostgreSQL and Elasticsearch.

## Problem definition
We have a simple information system for recording information of the game League of Legends (LoL), our task is to receive message from listener agent which contains the information of a finished match between two pro teams, we will save this information into the database for later used and also make some aggregations with the data. 

## The System
The controller of the system will be Spring Application, the incoming data will be pushed into Kafka producer and then to the topic inside broker, we have two Kafka consumer groups, the first one is to process the data for PostgreSQL and the second one is to process the data for Elasticsearch, the information will be saved into both PostgreSQL and Elasticsearch database, also we will record the performance of each pro team and record it into another table in PostgreSQL.
