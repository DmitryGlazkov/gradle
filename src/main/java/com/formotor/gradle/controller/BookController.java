package com.formotor.gradle.controller;


import com.formotor.gradle.component.BookComponent;
import com.formotor.gradle.model.Book;
import com.formotor.gradle.util.Selection;
import com.formotor.gradle.util.impl.BookSelection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookComponent bookComponent;

    @PostMapping("/books")
    public Book postBook(@Valid @RequestBody Book book) {
        return bookComponent.save(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookComponent.findAll();
    }

    @GetMapping("/books/select")
    public List<Book> getSelectBooks() {
        Selection<Book> selection = new BookSelection();

        return selection.someSelection(bookComponent.findAll());
    }

    @GetMapping("/books/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable(value = "title") String title) {
        Book titleBook = bookComponent.findAll()
                .stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList())
                .get(0);

        return ResponseEntity.ok().body(titleBook);
    }

    @PutMapping("/books/{title}")
    public ResponseEntity<Book> putBook(@PathVariable(value = "title") String title,
                                        @Valid @RequestBody Book bookDetails) {

        Book book = bookComponent.findAll()
                .stream()
                .filter(b -> b.getTitle().contains(title))
                .collect(Collectors.toList())
                .get(0);

        book.setAuthor(bookDetails.getAuthor());
        book.setDateOfPublication((bookDetails.getDateOfPublication()));
        book.setTitle(bookDetails.getTitle());

        Book updatedBook = bookComponent.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") Long id) {
        Book book = bookComponent.findOne(id);
        if(book == null) {
            return ResponseEntity.notFound().build();
        }

        bookComponent.delete(book);
        return ResponseEntity.ok().build();
    }
}
