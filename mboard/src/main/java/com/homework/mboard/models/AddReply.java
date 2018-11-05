package com.homework.mboard.models;

public class AddReply {
	
	private String user;
	private String comment;
	private Replies reply;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Replies getReply() {
		return reply;
	}
	public void setReply(Replies reply) {
		this.reply = reply;
	}
	
}
