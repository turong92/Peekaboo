package com.peekaboo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {
	//Like
	public int insertLike(@Param("content_id")Long content_id,@Param("user_id")String user_id);
	public List<Long> getLikeContent(@Param("user_id")String user_id);
	public List<String> getLikeUser(@Param("content_id")Long content_id);
	public int deleteLike(@Param("content_id")Long content_id,@Param("user_id")String user_id);
	public int isLike(@Param("content_id")Long content_id,@Param("user_id")String user_id);
	public int getLikeCnt(@Param("content_id")Long content_id);
}
