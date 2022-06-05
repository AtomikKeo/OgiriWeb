package model.entity;

import java.util.Date;

public class Odai {
	private int id;
	private int type;
	private String theme;
	private java.util.Date dueTime;
	private int status;
	private boolean allowMultiPost;
	
	public Odai(int id, int type, String theme, Date dueTime, int status, boolean allowMultiPost) {
		super();
		this.id = id;
		this.type = type;
		this.theme = theme;
		this.dueTime = dueTime;
		this.status = status;
		this.allowMultiPost = allowMultiPost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public java.util.Date getDueTime() {
		return dueTime;
	}
	public void setDueTime(java.util.Date dueTime) {
		this.dueTime = dueTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isAllowMultiPost() {
		return allowMultiPost;
	}
	public void setAllowMultiPost(boolean allowMultiPost) {
		this.allowMultiPost = allowMultiPost;
	}
	
	
}
