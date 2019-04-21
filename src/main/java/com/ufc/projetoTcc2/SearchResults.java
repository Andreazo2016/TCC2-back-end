package com.ufc.projetoTcc2;

import java.util.List;

public class SearchResults {

    private Integer total;
    
    private Integer total_pages;
   
    private List<Photo> results;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public List<Photo> getResults() {
		return results;
	}

	public void setResults(List<Photo> results) {
		this.results = results;
	}
   
}
