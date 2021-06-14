package com.peekaboo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MuteContentMapper {
	//MuteContent
	public int insertMute(@Param("user_id")String user,@Param("mute_content")Long mute);
	public List<Long> getMute(@Param("user_id")String user);
	public int deleteMute(@Param("user_id")String user,@Param("mute_content")Long mute);
	public int isMute(@Param("user_id")String user,@Param("mute_content")Long mute);
}
