package com.peekaboo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peekaboo.mapper.MuteContentMapper;

@Service
public class MuteContentServiceImpl implements MuteContentService{
	
	@Autowired
	private MuteContentMapper muteContentMapper;
	
	@Override
	public boolean insertMute(String userId, Long muteId) {
		int queryResult = 0;
		queryResult = muteContentMapper.insertMute(userId,muteId);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

	@Override
	public boolean deleteMute(String userId, Long muteId) {
		int queryResult = 0;
		queryResult = muteContentMapper.deleteMute(userId,muteId);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<Long> getMuteList(String userId) {
		return muteContentMapper.getMute(userId);
	}

	@Override
	public boolean isMute(String userId, Long muteId) {
		int queryResult = 0;
		queryResult = muteContentMapper.isMute(userId,muteId);
		System.out.println(queryResult);
		return (queryResult == 1) ? true : false;
	}

}
