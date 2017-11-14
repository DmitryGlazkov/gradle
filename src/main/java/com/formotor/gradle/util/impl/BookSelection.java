package com.formotor.gradle.util.impl;


import com.formotor.gradle.model.Book;
import com.formotor.gradle.util.Selection;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class BookSelection implements Selection<Book> {

    @Override
    public List<Book> someSelection(List<Book> books) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final Date dateForCompare = dateFormat.parse("2017-11-09", new ParsePosition(0));

        return books
                .stream()
                .filter(date -> date.getDateOfPublication().compareTo(dateForCompare) < 0)
                .filter(title -> title.getTitle().length() < 51)
                .filter(author -> author.getAuthor().matches("[A-ZА-Я]{1}[a-zа-я]+\\s[A-ZА-Я]{1}[a-zа-я]+\\s[A-ZА-Я]{1}[a-zа-я]+"))
                .collect(Collectors.toList());
    }
}
