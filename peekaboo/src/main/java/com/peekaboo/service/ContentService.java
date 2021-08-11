package com.peekaboo.service;

import java.util.List;

import com.peekaboo.domain.Content;

public interface ContentService {
	public boolean insertContent(Content content);
	public boolean deleteContent(Long contentId);
	public boolean updateContent(Content content);
	public List<Content> getMainContentByUserId(String userId);
	public Content getContentByContentId(Long contentId);
	public List<Content> getContentByUserId(String string);
	public List<Content> getReplyByContentId(Long contentId);
}
