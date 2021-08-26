package com.peekaboo.service;

import java.util.List;

public interface LikeService {
		//like
		public boolean insertLike(Long content_id,String user_id);
		public boolean deleteLike(Long content_id,String user_id);
		public List<String> getLikeUserList(Long user_id);
		public List<Long> getLikeContentList(String user_id);
		public boolean isLike(Long content_id,String user_id);
		public int getLikeCnt(Long contentId);
}
