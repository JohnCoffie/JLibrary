package jlibrary.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-id") 
	@GenericGenerator(name="system-id",strategy="increment") 
	@Column(name = "user_id", unique = true, nullable = false) 
	private int userId;
	
	@Column(name = "name", length = 50, nullable = false) 
	private String name;
	
	@Column(name = "password", length = 30, nullable = false) 
	private String password;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "sex", length = 1)
	private short sex;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public short getSex() {
		return sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
