package com.peekaboo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.domain.UserDTO;

@Mapper
public interface PeekabooMapper {
	public int insertContent(PeekabooDTO params);
	public PeekabooDTO selectDetail(Long idx);
	public int updateContent(PeekabooDTO params);
	public int deleteContent(Long idx);
	public List<PeekabooDTO> selectContentList();
	public int selectTotalCount();
	//userCRUD
	public int insertUser(UserDTO user);
	public UserDTO selectUser(String userId);
	public int updateUser(UserDTO user);
	public int deleteUser(String userId);
	//followCRUD
	public int insertFollow(String follower,String following);
	public Long getFollowId(String follower,String following);
	public List<String> getFollower(String following);
	public List<String> getFollowing(String follower);
	public int updateFollow(String follower,String following);
	public int deleteFollow(String follower,String following);
	//Mute
	public int insertMute(String follower,String following);
	public Long getMuteId(String user,String mute);
	public List<String> getMute(String user);
	public int updateMute(String follower,String following);
	public int deleteMute(String follower,String following);
	//Like
	public int insertLike(String content,String user);
	public Long getLikeId(String content,String user);
	public List<String> getLike(String user);
	public int updateLike(String content,String user);
	public int deleteLike(String content,String user);
	//Retweet < 생각을 더해봐야할듯
	
	
}
