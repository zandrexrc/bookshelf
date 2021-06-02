package com.zandrexrc.bookshelf.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OpenLibraryResponseDoc {
	
	private String coverEditionKey;
	private int coverI;
	
	public String getCoverEditionKey() {
		return coverEditionKey;
	}
	
	public int getCoverI() {
		return coverI;
	}
	
	public void setCoverEditionKey(String coverEditionKey) {
		this.coverEditionKey = coverEditionKey;
	}
	
	public void setCoverI(int coverI) {
		this.coverI = coverI;
	}
	
}