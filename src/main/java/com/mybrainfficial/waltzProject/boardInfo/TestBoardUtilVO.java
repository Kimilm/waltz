package com.mybrainfficial.waltzProject.boardInfo;

import java.io.Serializable;

public class TestBoardUtilVO implements Serializable {
	private String search;
	private int page;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
