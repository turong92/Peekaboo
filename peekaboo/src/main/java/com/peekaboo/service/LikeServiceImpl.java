package com.peekaboo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peekaboo.mapper.FollowMapper;
import com.peekaboo.mapper.LikeMapper;


@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	private LikeMapper likeMapper;

	@Override
	public boolean insertLike(Long content_id, String user_id) {
		int queryResult = 0;
		queryResult = likeMapper.insertLike(content_id,user_id);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

	@Override
	public boolean deleteLike(Long content_id, String user_id) {
		int queryResult = 0;
		queryResult = likeMapper.deleteLike(content_id,user_id);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<String> getLikeUserList(Long user_id) {
		return likeMapper.getLikeUser(user_id);
	}

	@Override
	public List<Long> getLikeContentList(String user_id) {
		return likeMapper.getLikeContent(user_id);
	}

	@Override
	public boolean isLike(Long content_id, String user_id) {
		int queryResult = 0;
		queryResult = likeMapper.isLike(content_id,user_id);
		return (queryResult == 1) ? true : false;
	}

	
	
}
