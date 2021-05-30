package com.peekaboo.service;

import com.peekaboo.domain.User;

public interface UserService {
	public User findByUserId(String user_id);
	public boolean signUp(User user);
}
