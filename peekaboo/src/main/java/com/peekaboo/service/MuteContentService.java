package com.peekaboo.service;

import java.util.List;

public interface MuteContentService {
	//mute
		public boolean insertMute(String userId,Long muteId);
		public boolean deleteMute(String userId,Long muteId);
		public List<Long> getMuteList(String userId);
		public boolean isMute(String userId,Long muteId);
}
