package com.example.api.output;

import java.util.ArrayList;
import java.util.List;


import com.example.dto.NewDTO;

public class NewOutput {
	private long page ;
	private long totalPages ;
	private String sortName ;
	private String sortBy ;
	private List<NewDTO> listResults = new ArrayList<>();
	
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}
	public List<NewDTO> getListResults() {
		return listResults;
	}
	public void setListResults(List<NewDTO> listResults) {
		this.listResults = listResults;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
}
