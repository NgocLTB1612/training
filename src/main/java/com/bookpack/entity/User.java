package com.bookpack.entity;
import javax.persistence.*;


import com.bookpack.audit.Auditable;
import lombok.Data;

@Data
@Entity
@Table( name = "user")
public class User extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column( name = "username")
	private String username;

	@Column( name = "email")
	private String email;

	@Column( name = "password")
	private String password;

	public User(){
	}

	public User(int id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
