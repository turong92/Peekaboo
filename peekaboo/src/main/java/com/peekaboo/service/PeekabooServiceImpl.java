package com.peekaboo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peekaboo.domain.ContentDTO;
import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.domain.UserDTO;
import com.peekaboo.mapper.PeekabooMapper;

@Service
public class PeekabooServiceImpl implements PeekabooService{
	
	@Autowired
	private PeekabooMapper peekabooMapper;
	
	@Override
	public boolean registerPeekaboo(PeekabooDTO params) {
		int queryResult = 0;
		
		if(params.getIdx() == null) {
			queryResult = peekabooMapper.insertContent(params);
		} else {
			queryResult = peekabooMapper.updateContent(params);
		}
		return (queryResult == 1) ? true : false;
	}

	@Override
	public PeekabooDTO getPeekabooDetail(Long idx) {
		return peekabooMapper.selectDetail(idx);
	}

	@Override
	public boolean deletePeekaboo(Long idx) {
		int queryResult = 0;
		
		PeekabooDTO peekaboo = peekabooMapper.selectDetail(idx);
		
		if(peekaboo != null && peekaboo.getDeleteYn().equals("N")) {
			queryResult = peekabooMapper.deleteContent(idx);
		}
		
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<PeekabooDTO> getPeekabooList() {
		List<PeekabooDTO> peekabooList = Collections.emptyList();
		
		int totalCount = peekabooMapper.selectTotalCount();
		
		if(totalCount > 0) {
			peekabooList = peekabooMapper.selectContentList();
		}
		return peekabooList;
	}
	//user
	@Override
	public boolean insertUser(UserDTO user) {
		int queryResult = 0;
		
		if(user.getUserId() == null) {
			queryResult = peekabooMapper.insertUser(user);
		} else {
			queryResult = peekabooMapper.updateUser(user);
		}
		return (queryResult == 1) ? true : false;
	}

	

	@Override
	public UserDTO getUser(Long idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(Long idx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDTO> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	//content
	@Override
	public UserDTO getContent(Long idx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean insertContent(ContentDTO content) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteContent(Long idx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDTO> getContentList() {
		// TODO Auto-generated method stub
		return null;
	}
	//follow
	@Override
	public boolean insertFollow(String follower, String following) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFollow(String follower, String following) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getFollowerList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getFollowingList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	//mute
	@Override
	public boolean insertMute(String userId, String muteId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMute(String userId, String muteId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getMuteList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	//like
	@Override
	public boolean insertLike(String contentId, String following) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLike(String contentId, String following) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getLikeUserList(Long contentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> getLikeContentList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
