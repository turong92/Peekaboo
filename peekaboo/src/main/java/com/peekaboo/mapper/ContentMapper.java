package com.peekaboo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.peekaboo.domain.Content;

@Mapper
public interface ContentMapper {
	//Content
	public int insertContent(Content content);
	public int deleteContent(Long contentId);
	public int updateContent(Content content);
	public List<Content> getMainContentByUserId(String userId);
	public Content getContentByContentId(Long contentId);
	
}
