package com.peekaboo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.peekaboo.domain.User;

@Mapper
public interface UserMapper {
	public User findByUserId(String userId);
	public int signUp(User user);
}
