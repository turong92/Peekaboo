package com.peekaboo.domain;

import java.security.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
public class User {
	private String id;
	private String user_id;
	private String user_name;
	private String user_picture;
	private String user_number;
	private String user_email;
	private int user_follower_cnt;
	private int user_following_cnt;
	private Timestamp user_join_date;
	private Timestamp user_birth;
	private String user_intro;
	
	private String provider;
	private String role;
	
	@Builder
	public User(String id, String user_id, String user_name, String user_picture, String user_number, String user_email,
			int user_follower_cnt, int user_following_cnt, Timestamp user_join_date, Timestamp user_birth,
			String user_intro, String provider, String role) {
		this.id = id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_picture = user_picture;
		this.user_number = user_number;
		this.user_email = user_email;
		this.user_follower_cnt = user_follower_cnt;
		this.user_following_cnt = user_following_cnt;
		this.user_join_date = user_join_date;
		this.user_birth = user_birth;
		this.user_intro = user_intro;
		this.provider = provider;
		this.role = role;
	}
	
	
}
