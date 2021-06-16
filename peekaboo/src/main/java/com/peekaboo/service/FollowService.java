package com.peekaboo.service;

import java.util.List;

public interface FollowService {
	//follow
		public boolean insertFollow(String follower_id,String following_id);
		public boolean deleteFollow(String follower_id,String following_id);
		public List<String> getFollowerList(String userId);
		public List<String> getFollowingList(String userId);
		public boolean isFollow(String follower_id,String following_id);
}
