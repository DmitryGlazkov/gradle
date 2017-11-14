package com.formotor.gradle.component;

import com.formotor.gradle.model.Book;
import com.formotor.gradle.repository.BookRepository;

import org.springframework.stereotype.Component;


@Component
public interface BookComponent extends BookRepository<Book, Long> {}
