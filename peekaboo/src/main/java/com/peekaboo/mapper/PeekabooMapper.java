package com.peekaboo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.peekaboo.domain.PeekabooDTO;

@Mapper
public interface PeekabooMapper {
	public int insertContent(PeekabooDTO params);
	public PeekabooDTO selectDetail(Long idx);
	public int updateContent(PeekabooDTO params);
	public int deleteContent(Long idx);
	public List<PeekabooDTO> selectContentList();
	public int selectTotalCount();
}
