package com.peekaboo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.domain.User;
import com.peekaboo.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByUserId(String user_id) {
		return userMapper.findByUserId(user_id);
	}
	
	@Override
	public boolean signUp(User user) {
		int queryResult = 0;
		
		queryResult = userMapper.signUp(user);
		
		return (queryResult == 1) ? true : false;
	}
	
//	@Override
//	public boolean registerPeekaboo(PeekabooDTO params) {
//		int queryResult = 0;
//		
//		if(params.getIdx() == null) { //이미 저장된 게시물이 아니면 등록이고 저장된 게시물이면 수정
//			queryResult = peekabooMapper.insertContent(params);
//		} else {
//			queryResult = peekabooMapper.updateContent(params);
//		}
//		return (queryResult == 1) ? true : false;
//	}
}
