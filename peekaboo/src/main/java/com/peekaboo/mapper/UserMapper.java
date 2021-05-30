package com.peekaboo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.peekaboo.domain.User;

@Mapper
public interface UserMapper {
	public User findByUserId(String user_id);
	public int signUp(User user);
}
