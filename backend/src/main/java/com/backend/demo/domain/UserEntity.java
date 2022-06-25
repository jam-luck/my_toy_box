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
	@Column(nullable = false, length = 30)
	private String name;
	@Column(nullable = false, length = 50)
	private String userId;
	@Column(nullable = false, length = 50)
	private String userPwd;
	@Column(nullable = false, length = 10)
	private String type;
	
	@Builder
	public UserEntity(String name,String userId,String userPwd,String type) {
		this.name = name;
		this.userId = userId;
		this.userPwd = userPwd;
		this.type = type;
	}
}
