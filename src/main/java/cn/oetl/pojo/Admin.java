package cn.oetl.pojo;

import java.io.Serializable;
import java.util.List;

public class Admin implements Serializable {
	Integer admin_id;
	String name;
	String password;
	String phone;
	String email;

	// 注入News属性
	List<News> newses;

	@Override
	public String toString() {
		return admin_id + name;
	}

	// getters and setters
	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<News> getNewses() {
		return newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}
}
