package com.yedam.board.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceImpl;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class boardselectControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String no = req.getParameter("bno");
		BoardService service = new BoardServiceImpl();
		BoardVO vo = service.getBoard(Long.parseLong(no));
		
		req.setAttribute("board", vo);
		
		return "board/boardsearch.tiles";
	}

}
