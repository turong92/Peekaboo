package com.peekaboo.domain;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
public class Content {
	private Long contentId;
	private String userId;
	private String userName;
	private int allowRange;
	private Long replyId;
	private String contentText;
	private String contentPicture;
	private int commentCnt;
	private int likeCnt;
	private String isDelete;
	private String isUpdate;
	private Timestamp postTime;
	private Timestamp deleteTime;
	private Timestamp updateTime;
	
	@Builder
	public Content(Long contentId,
			String userId,
			String userName,
			int allowRange,
			Long replyId,
			String contentText,
			String contentPicture,
			int commentCnt,
			int likeCnt,
			String isDelete,
			String isUpdate,
			Timestamp postTime,
			Timestamp deleteTime,
			Timestamp updateTime) {
		this.contentId=contentId;
		this.userId=userId;
		this.userName=userName;
		this.allowRange=allowRange;
		this.replyId=replyId;
		this.contentText=contentText;
		this.contentPicture=contentPicture;
		this.commentCnt=commentCnt;
		this.likeCnt=likeCnt;
		this.isDelete=isDelete;
		this.isUpdate=isUpdate;
		this.postTime=postTime;
		this.deleteTime=deleteTime;
		this.updateTime=updateTime;
	}
	
}
