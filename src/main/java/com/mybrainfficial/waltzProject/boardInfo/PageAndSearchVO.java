package com.mybrainfficial.waltzProject.boardInfo;

import java.io.Serializable;

public class PageAndSearchVO implements Serializable {
	private String search;
	private Integer page;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
}
