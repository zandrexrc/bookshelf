package com.zandrexrc.bookshelf;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.zandrexrc.bookshelf.domains.Book;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends MongoRepository<Book, String> {
	
	public List<Book> findByTitle(@Param("title") String title);
	public List<Book> findByStatus(@Param("status") String status);
	
}