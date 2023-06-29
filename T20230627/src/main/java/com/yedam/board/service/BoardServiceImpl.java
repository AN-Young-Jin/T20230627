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
	public List<BoardVO> list() {
		return mapper.boardList();
	}

	@Override
	public BoardVO getBoard(long brdNo) {
		return mapper.selectBoard(brdNo);
	}

}
