package com.formotor.gradle.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.annotation.Nullable;

import java.util.Date;


@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
public class Book {

    public Book() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author")
    @Nullable
    @Length(max = 50)
    private String author;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_publication")
    @Nullable
    private Date dateOfPublication;

    @Column(name = "title")
    @Nullable
    @Length(max = 100)
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                ", title='" + title + '\'' +
                '}';
    }
}
