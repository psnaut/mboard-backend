package com.homework.mboard.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Posts {
	@Id
	private Object _id;
	private String user;
	private String comment;
	private String city;
	//TODO: Consider changing type to double
	private String latitude;
	private String longitude;
	private String weather;
	private List<Replies> replies;
	
	public Object get_id() {
		return _id;
	}
	public void set_id(Object _id) {
		this._id = _id;
	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public List<Replies> getReplies() {
		return replies;
	}
	public void setReplies(List<Replies> replies) {
		this.replies = replies;
	}


}
