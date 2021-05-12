package com.peekaboo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.mapper.PeekabooMapper;

@Service
public class PeekabooServiceImpl implements PeekabooService{
	
	@Autowired
	private PeekabooMapper peekabooMapper;
	
	@Override
	public boolean registerPeekaboo(PeekabooDTO params) {
		int queryResult = 0;
		
		if(params.getIdx() == null) { //이미 저장된 게시물이 아니면 등록이고 저장된 게시물이면 수정
			queryResult = peekabooMapper.insertContent(params);
		} else {
			queryResult = peekabooMapper.updateContent(params);
		}
		return (queryResult == 1) ? true : false;
	}

	@Override
	public PeekabooDTO getPeekabooDetail(Long idx) {
		return peekabooMapper.selectDetail(idx);
	}

	@Override
	public boolean deletePeekaboo(Long idx) {
		int queryResult = 0;
		
		PeekabooDTO peekaboo = peekabooMapper.selectDetail(idx);
		
		if(peekaboo != null && peekaboo.getDeleteYn().equals("N")) {
			queryResult = peekabooMapper.deleteContent(idx);
		}
		
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<PeekabooDTO> getPeekabooList() {
		List<PeekabooDTO> peekabooList = Collections.emptyList();
		
		int totalCount = peekabooMapper.selectTotalCount();
		
		if(totalCount > 0) {
			peekabooList = peekabooMapper.selectContentList();
		}
		return peekabooList;
	}
}
