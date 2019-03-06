package entity;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	String username;
	String name;
	int age;
	String password;
	String slogan;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	@Override
	public String toString() {
		return "Person [username=" + username + ", name=" + name + ", age=" + age + ", password=" + password
				+ ", slogan=" + slogan + "]";
	}
}
