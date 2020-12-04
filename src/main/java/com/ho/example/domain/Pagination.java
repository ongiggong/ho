package com.ho.example.domain;

public class Pagination {
	int contentCount;
	int totalCount;
	int page;
	int pageNum;
	int startPage;
	int endPage;
	int lastPage;
	int prevPage;
	int nextPage;
	public static final int pageUnit=5;
	public static final int perPage=3;
	
	public Pagination(int page, int totalCount) { 
		this.page = page;
		this.totalCount = totalCount;
		
		startPage = ((page-1)/pageUnit)*pageUnit+1;
		lastPage = (int)Math.ceil(totalCount / (float)perPage);
		endPage = startPage+pageUnit-1;
		endPage = endPage < lastPage ? endPage : lastPage;
		prevPage=(endPage-pageUnit);
		nextPage=(startPage+pageUnit);
	
	}

	public int getBoardCount() {
		return contentCount;
	}

	public void setBoardCount(int boardCount) {
		this.contentCount = boardCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

		
	public static int getPageunit() {
		return pageUnit;
	}

	public static int getPerpage() {
		return perPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	

}
