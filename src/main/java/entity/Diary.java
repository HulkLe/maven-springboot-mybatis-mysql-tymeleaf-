package entity;

import java.util.Date;

import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

public class Diary {
	
	int id;
	String username;
	String diary;
	Date datetime;
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
	public String getDiary() {
		return diary;
	}
	public void setDiary(String diary) {
		this.diary = diary;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Diary [id=" + id + ", username=" + username + ", diary=" + diary + ", datetime=" + datetime + "]";
	}

}
