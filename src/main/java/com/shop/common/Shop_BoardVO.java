package com.shop.common;

import java.util.Date;

public class Shop_BoardVO {
	private int no;
	private String tit;
	private String con;
	private String writer;
	private Date regdate;
	private int viewed;
	private int thumb;
	private int lock_post;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewed() {
		return viewed;
	}
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
	public int getThumb() {
		return thumb;
	}
	public void setThumb(int thumb) {
		this.thumb = thumb;
	}
	public int getLock_post() {
		return lock_post;
	}
	public void setLock_post(int lock_post) {
		this.lock_post = lock_post;
	}
	
}
