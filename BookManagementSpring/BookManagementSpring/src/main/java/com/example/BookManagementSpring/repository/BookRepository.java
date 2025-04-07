package com.example.BookManagementSpring.repository;

import com.example.BookManagementSpring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

//Book → the entity class (this maps to your DB table).

//Long → the type of the primary key field in the Book class.

//💡 Why is this important?
//Because Spring Data JPA methods like:
//findById(Long id)
//deleteById(Long id)
//existsById(Long id)
//all rely on that primary key type to work properly.