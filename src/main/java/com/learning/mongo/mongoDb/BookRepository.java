package com.learning.mongo.mongoDb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {

    public Book findByauthorName(String name);

}
