package com.ho.example.domain;

public class Board {
	private int idx;
	private String id;
	private String title;
	private String text;
	private String uploadtime;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	
	@Override
	public String toString() {
		return "Board [idx=" + idx + ", id=" + id + ", title=" + title + ", text=" + text + ", uploadtime=" + uploadtime
				+ "]";
	}
	public void setRownum(int int1) {
	
	}
	

}
