package com.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.dao.BoardMapper;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.DataSource;

public class BoardServiceImpl implements BoardService{
	
	SqlSession session = DataSource.getInstance().openSession(true);
	BoardMapper mapper = session.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> list(int page) {
		return mapper.boardList(page);
	}

	@Override
	public BoardVO getBoard(long brdNo) {
		return mapper.selectBoard(brdNo);
	}



	@Override
	public int page() {
		return mapper.page();
	}

}
