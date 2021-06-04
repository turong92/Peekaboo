package com.peekaboo.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PeekabooDTO {
	private Long idx;
	private String title;
	private String content;
	private String id;
	private int viewCnt;
	private String noticeYn;
	private String secretYn;
	private String deleteYn;
	private LocalDateTime insertTime;
	private LocalDateTime updateTime;
	private LocalDateTime deleteTime;
}
