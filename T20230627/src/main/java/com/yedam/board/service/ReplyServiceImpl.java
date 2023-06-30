package com.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.dao.ReplyMapper;
import com.yedam.board.vo.ReplyVO;
import com.yedam.common.DataSource;

public class ReplyServiceImpl implements ReplyService{
	SqlSession session = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	
	@Override
	public List<ReplyVO> replyList(long brdNo) {
		return mapper.selectList(brdNo);
	}

	@Override
	public ReplyVO getReply(long replyNO) {
		return mapper.selectOne(replyNO);
	}

	@Override
	public boolean addReply(ReplyVO vo) {
		return mapper.insertReply(vo) == 1;
	}

	@Override
	public boolean modify(ReplyVO vo) {
		return mapper.updateReply(vo) == 1;
	}

	@Override
	public boolean remove(long replyNO) {
		return mapper.deleteReply(replyNO) == 1;
	}
	
}
