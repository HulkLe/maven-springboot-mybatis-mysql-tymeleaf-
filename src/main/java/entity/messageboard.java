package entity;

import java.util.Date;

public class messageboard {
	
	int id;
	String username1;
	String username2;
	Date datetime;
	String diary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername1() {
		return username1;
	}
	public void setUsername1(String username1) {
		this.username1 = username1;
	}
	public String getUsername2() {
		return username2;
	}
	public void setUsername2(String username2) {
		this.username2 = username2;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getDiary() {
		return diary;
	}
	public void setDiary(String diary) {
		this.diary = diary;
	}
	@Override
	public String toString() {
		return "messageboard [id=" + id + ", username1=" + username1 + ", username2=" + username2 + ", datetime="
				+ datetime + ", diary=" + diary + "]";
	}

}
