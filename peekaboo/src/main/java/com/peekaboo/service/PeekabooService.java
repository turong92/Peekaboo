package com.peekaboo.service;
import java.util.List;
import com.peekaboo.domain.PeekabooDTO;

public interface PeekabooService {
	public boolean registerPeekaboo(PeekabooDTO params);
	public PeekabooDTO getPeekabooDetail(Long idx);
	public boolean deletePeekaboo(Long idx);
	public List<PeekabooDTO> getPeekabooList();
}
