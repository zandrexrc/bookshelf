package com.zandrexrc.bookshelf;

import com.zandrexrc.bookshelf.domains.Book;
import com.zandrexrc.bookshelf.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class BookEventHandler {

    private final BookService bookService;

    @Autowired
    public BookEventHandler(BookService bookService) {
        this.bookService = bookService;
    }

    @HandleBeforeCreate
    public void handleBookBeforeCreate(Book book) {
        // Get cover image from OpenLibrary
        book.setCoverImage(bookService.getCoverImage(book));
    }

}
