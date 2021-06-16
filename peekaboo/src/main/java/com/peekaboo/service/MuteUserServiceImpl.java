package com.peekaboo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peekaboo.mapper.MuteContentMapper;
import com.peekaboo.mapper.MuteUserMapper;

@Service
public class MuteUserServiceImpl implements MuteUserService{
	
	@Autowired
	private MuteUserMapper muteUserMapper;
	
	@Override
	public boolean insertMute(String userId, String muteId) {
		int queryResult = 0;
		queryResult = muteUserMapper.insertMute(userId,muteId);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

	@Override
	public boolean deleteMute(String userId, String muteId) {
		int queryResult = 0;
		queryResult = muteUserMapper.deleteMute(userId,muteId);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<String> getMuteList(String userId) {
		return muteUserMapper.getMute(userId);
	}

	@Override
	public boolean isMute(String userId, String muteId) {
		int queryResult = 0;
		queryResult = muteUserMapper.isMute(userId,muteId);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

}
