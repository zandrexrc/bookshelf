package com.zandrexrc.bookshelf.services;

import com.zandrexrc.bookshelf.domains.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zandrexrc.bookshelf.domains.OpenLibraryResponse;
import com.zandrexrc.bookshelf.domains.OpenLibraryResponseDoc;

@Service
public class BookService {

	private static final String QUERY_URL_TEMPLATE = "http://openlibrary.org/search.json?title=%s&author=%s";
	private static final String COVER_IMAGE_TEMPLATE = "http://covers.openlibrary.org/b/%s/%s-S.jpg";
	
	private RestTemplate restTemplate;
	private QueryFormatter queryFormatter;
	
	public BookService() {
		super();
	}
	
	@Autowired
	public BookService(RestTemplate restTemplate, QueryFormatter queryFormatter) {
		super();
		this.restTemplate = restTemplate;
		this.queryFormatter = queryFormatter;
	}
	
	private String queryUrlBuilder(Book book) {
		String queryUrl = String.format(QUERY_URL_TEMPLATE, book.getTitle(), book.getAuthors().get(0));
		return queryFormatter.format(queryUrl);
	}
	
	public String getCoverImage(Book book) {
		OpenLibraryResponse res = restTemplate.getForObject(queryUrlBuilder(book), OpenLibraryResponse.class);
		String coverImage = "";
		
		if (res != null && res.getNumFound() > 0) {
			for (int i = 0; i < res.getNumFound(); i++) {
				OpenLibraryResponseDoc doc = res.getDocs().get(i);
				if (doc.getCoverEditionKey() != null) {
					coverImage = String.format(COVER_IMAGE_TEMPLATE, "olid", doc.getCoverEditionKey());
					break;
				} else if (doc.getCoverI() != 0) {
					coverImage = String.format(COVER_IMAGE_TEMPLATE, "id", doc.getCoverI());
					break;
				}
			}
		}
		
		return coverImage;
	}
	
}