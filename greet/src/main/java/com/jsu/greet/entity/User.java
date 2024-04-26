package com.jsu.greet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 3, message = "用户名长度至少为3")
	private String username;
	@NotBlank(message = "密码不能为空")
	private String password;
	@NotBlank(message = "密码不能为空")
	@Transient
	private String password2;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	private String cnname;
	private int sex;
	private String mobile;
	private String email;
	private String note;
}
