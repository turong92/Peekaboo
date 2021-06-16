package com.peekaboo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MuteUserMapper {
	//Mute
	public int insertMute(@Param("user_id")String user,@Param("mute_user")String mute);
	public List<String> getMute(@Param("user_id")String user);
	public int deleteMute(@Param("user_id")String user,@Param("mute_user")String mute);
	public int isMute(@Param("user_id")String user,@Param("mute_user")String mute);
}
