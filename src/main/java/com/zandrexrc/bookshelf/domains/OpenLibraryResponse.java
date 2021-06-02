package com.zandrexrc.bookshelf.domains;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenLibraryResponse {
	
	private int numFound;
	private List<OpenLibraryResponseDoc> docs;
	
	public int getNumFound() {
		return numFound;
	}
	
	public List<OpenLibraryResponseDoc> getDocs() {
		return docs;
	}
	
	public void setNumFound(int numFound) {
		this.numFound = numFound;
	}
	
	public void setDocs(List<OpenLibraryResponseDoc> docs) {
		this.docs = docs;
	}
	
}