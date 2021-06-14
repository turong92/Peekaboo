package com.peekaboo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peekaboo.mapper.FollowMapper;


@Service
public class FollowServiceImpl implements FollowService{
	@Autowired
	private FollowMapper followMapper;
	
	@Override
	public boolean insertFollow(String follower_id, String following_id) {
		int queryResult = 0;
		queryResult = followMapper.insertFollow(follower_id,following_id);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<String> getFollowerList(String userId) {
		return followMapper.getFollower(userId);
	}

	@Override
	public List<String> getFollowingList(String userId) {
		return followMapper.getFollowing(userId);
	}
	
	@Override
	public boolean deleteFollow(String follower_id, String following_id) {
		int queryResult = 0;
		queryResult = followMapper.deleteFollow(follower_id,following_id);
		return (queryResult == 1) ? true : false;
	}

	@Override
	public boolean isFollow(String follower_id, String following_id) {
		int queryResult = 0;
		queryResult = followMapper.isFollow(follower_id,following_id);
		return (queryResult == 1) ? true : false;
	}
}
