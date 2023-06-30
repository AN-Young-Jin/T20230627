package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.dao.ReplyMapper;
import com.yedam.board.vo.ReplyVO;

public class TestMain {

	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		ReplyVO reply = new ReplyVO();
		reply.setBrdNo(1857);
		reply.setReply("gd");
		reply.setReplyNo(7);
		reply.setReplyer("홍규염");
		
//		mapper.insertReply(reply);
//		mapper.updateReply(reply);
		mapper.deleteReply(7);
		List<ReplyVO> list = mapper.selectList(1857);
		
		for(ReplyVO vo : list) {
			System.out.println(vo.toString());
		}
		
	}
}
