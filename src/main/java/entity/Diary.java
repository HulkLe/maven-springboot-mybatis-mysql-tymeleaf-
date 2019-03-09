package entity;

import org.springframework.stereotype.Component;

@Component
public class Diary {
	
	int id;
	String username;
	String content;
    String datetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Diary [id=" + id + ", username=" + username + ", content=" + content + ", datetime=" + datetime + "]";
	}
	
}
	
