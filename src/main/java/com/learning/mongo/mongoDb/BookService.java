package com.learning.mongo.mongoDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //Service class we can write all logic

    @Autowired
    BookRepository bookRepository;

    public void insert(Book book){
     bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBookName(String name){
        return bookRepository.findByauthorName(name);
    }

    //Here if there is any failur in between then we have to handle by deleteing what was inserted
    public void bulkInsert(List<Book> books){
        try {
            bookRepository.saveAll(books);
        }catch (Exception e){
            bookRepository.deleteAll(books);
        }
    }
}
