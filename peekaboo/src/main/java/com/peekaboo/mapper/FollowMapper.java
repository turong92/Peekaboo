package com.peekaboo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowMapper {
	//followCRUD
	public int insertFollow(@Param("follower_id")String follower_id,@Param("following_id")String following_id);
	public List<String> getFollower(@Param("following_id")String following_id);
	public List<String> getFollowing(@Param("follower_id")String follower_id);
	public int deleteFollow(@Param("follower_id")String follower_id,@Param("following_id")String following_id);
	public int isFollow(@Param("follower_id")String follower_id,@Param("following_id")String following_id);
}
