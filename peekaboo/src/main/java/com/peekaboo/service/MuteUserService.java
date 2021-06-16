package com.peekaboo.service;

import java.util.List;

public interface MuteUserService {
	//mute
		public boolean insertMute(String userId,String muteId);
		public boolean deleteMute(String userId,String muteId);
		public List<String> getMuteList(String userId);
		public boolean isMute(String userId,String muteId);
}
