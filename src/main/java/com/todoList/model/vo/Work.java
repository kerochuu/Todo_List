package com.todoList.model.vo;

import java.time.LocalDateTime;

public class Work {

	private int no;
	private String name;
	private String type;
	private String content;
//	private LocalDateTime date;
	private String date;
	
	public Work() {
		super();
	}

	public Work(String name, String type, String content, String date) {
		super();
		this.name = name;
		this.type = type;
		this.content = content;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Work [no=" + no + ", name=" + name + ", type=" + type + ", content=" + content + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
//	public LocalDateTime getDate() {
//		return date;
//	}
//	
//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}

}
