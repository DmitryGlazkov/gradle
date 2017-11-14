package com.formotor.gradle.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


@NoRepositoryBean
public interface BookRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {}
