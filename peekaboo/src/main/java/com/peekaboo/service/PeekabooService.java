package com.peekaboo.service;
import java.util.List;

import com.peekaboo.domain.ContentDTO;
import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.domain.UserDTO;

public interface PeekabooService {
	public boolean registerPeekaboo(PeekabooDTO params);
	public PeekabooDTO getPeekabooDetail(Long idx);
	public boolean deletePeekaboo(Long idx);
	public List<PeekabooDTO> getPeekabooList();
	//user
	public boolean insertUser(UserDTO user);
	public UserDTO getUser(Long idx);
	public boolean deleteUser(Long idx);
	public List<UserDTO> getUserList();
	
	//content
	public boolean insertContent(ContentDTO content);
	public UserDTO getContent(Long idx);
	public boolean deleteContent(Long idx);
	public List<UserDTO> getContentList();
	//follow
	public boolean insertFollow(String follower,String following);
	public boolean deleteFollow(String follower,String following);
	public List<String> getFollowerList(String userId);
	public List<String> getFollowingList(String userId);
	//mute
	public boolean insertMute(String userId,String muteId);
	public boolean deleteMute(String userId,String muteId);
	public List<String> getMuteList(String userId);
	//like
	public boolean insertLike(String contentId,String following);
	public boolean deleteLike(String contentId,String following);
	public List<String> getLikeUserList(Long contentId);
	public List<Long> getLikeContentList(String userId);
	//retweet
}
