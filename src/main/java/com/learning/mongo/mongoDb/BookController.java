package com.learning.mongo.mongoDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    //Here in monogo DB we have created an index with name and unique is true , hence we can return book, else we have to return List<Book>
    @GetMapping("/book/{name}")
    public Book getBookByName(@PathVariable String name){
        return bookService.getBookName(name);
    }

    @PostMapping("/insert")
    public void insertBook(@RequestBody Book book){
        bookService.insert(book);
    }

    @PostMapping("/bulk/insert")
    public void bulkInsert(@RequestBody List<Book> books){
        bookService.bulkInsert(books);
    }
}
