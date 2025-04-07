package com.example.BookManagementSpring.controller;


import com.example.BookManagementSpring.entity.Book;
import com.example.BookManagementSpring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/test")
    public String testApi() {
        return "It works!";
    }


    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        else{
            return null;
        }

    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "Book id with " +  id + " has been deleted";
    }




}
