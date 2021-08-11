package com.peekaboo.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
public class User {
	private String id;
	private String userId;
	private String userName;
	private String userPicture;
	private String userNumber;
	private String userEmail;
	private int userFollowerCnt;
	private int userFollowingCnt;
	private Timestamp userJoinDate;
	private Timestamp userBirth;
	private String userIntro;
	
	private String provider;
	private String role;
	
	
	@Builder
	public User(String id, String userId, String userName, String userPicture, String userNumber, String userEmail,
			int userFollowerCnt, int userFollowingCnt, Timestamp userJoinDate, Timestamp userBirth,
			String userIntro, String provider, String role) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.userPicture = userPicture;
		this.userNumber = userNumber;
		this.userEmail = userEmail;
		this.userFollowerCnt = userFollowerCnt;
		this.userFollowingCnt = userFollowingCnt;
		this.userJoinDate = userJoinDate;
		this.userBirth = userBirth;
		this.userIntro = userIntro;
		this.provider = provider;
		this.role = role;
	}
}
