package com.peekaboo.service;
import java.util.List;


import com.peekaboo.domain.PeekabooDTO;
import com.peekaboo.domain.User;

public interface PeekabooService {
	public boolean registerPeekaboo(PeekabooDTO params);
	public PeekabooDTO getPeekabooDetail(Long idx);
	public boolean deletePeekaboo(Long idx);
	public List<PeekabooDTO> getPeekabooList();

	public long registerPeekaboo1(PeekabooDTO params);
}
