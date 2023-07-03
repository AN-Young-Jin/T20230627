package com.yedam.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.board.vo.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> selectList(@Param("brdNo") long brdNo, @Param("page") int page); //댓글 목록 원본글 조회이기에brdNo
	public int selectCount(long brdNo);
	public ReplyVO selectOne(long replyNo); //댓글한건조회 댓글 번호기준
	public int insertReply(ReplyVO vo);//등록
	public int updateReply(ReplyVO vo);//수정
	public int deleteReply(long replyNo);//삭제
}
