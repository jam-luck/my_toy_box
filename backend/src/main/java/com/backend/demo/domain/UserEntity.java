package com.backend.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	@Column(nullable = false, length = 50)
	private String email;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false, length = 10)
	private String type;
	
	@Builder
	public UserEntity(String email,String password,String type) {
		this.email = email;
		this.password = password;
		this.type = type;
	}
}
