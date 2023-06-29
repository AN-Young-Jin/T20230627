package com.yedam.board.control;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceImpl;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;


public class boardListControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
//		
//		String page = req.getParameter("page");
//		page = page == null ? "1" : page;
		
		BoardService service = new BoardServiceImpl();
		
		List<BoardVO> list = service.list();
		
		req.setAttribute("list", list);
		
		return "board/boardList.tiles";
	}

}
