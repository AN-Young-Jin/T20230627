package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> list(int page);
	public BoardVO getBoard (long brdNo);
	public int page();
}
