package com.yedam;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.control.AddReplyControl;
import com.yedam.board.control.DelReplyControl;
import com.yedam.board.control.EditReplyControl;
import com.yedam.board.control.ReplyControl;
import com.yedam.board.control.ReplyListControl;
import com.yedam.board.control.boardListControl;
import com.yedam.board.control.boardselectControl;
import com.yedam.calendar.control.AddEventControl;
import com.yedam.calendar.control.EventForm;
import com.yedam.calendar.control.EventListControl;
import com.yedam.calendar.control.RemoveEventControl;
import com.yedam.common.Control;
import com.yedam.member.control.CalendarForm;
import com.yedam.member.control.ChartDataControl;
import com.yedam.member.control.ChartFormControl;
import com.yedam.member.control.ImageUploadControl;
import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.MemberAddControl;
import com.yedam.member.control.MemberEditJson;
import com.yedam.member.control.MemberInfoControl;
import com.yedam.member.control.MemberInfoJson;
import com.yedam.member.control.MemberListControl;
import com.yedam.member.control.MemberListJquery;
import com.yedam.member.control.MemberListJson;
import com.yedam.member.control.MemberModifyControl;

public class FrontController extends HttpServlet{
	
	private HashMap<String, Control> menu;
	public FrontController() {
		menu = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		menu.put("/main.do", new MainControl());
		
		menu.put("/memberList.do", new MemberListControl());
		menu.put("/loginFrom.do", new LoginFormControl());
		menu.put("/login.do", new LoginControl());
		menu.put("/memberInfo.do", new MemberInfoControl());
		menu.put("/memberModify.do", new MemberModifyControl());
		menu.put("/imageUpload.do", new ImageUploadControl());
		
		menu.put("/memberListJquery.do", new MemberListJquery());
		menu.put("/memberListJson.do", new MemberListJson());
		menu.put("/memberInfoJson.do", new MemberInfoJson());
		
		menu.put("/memberAdd.do", new MemberAddControl());
		menu.put("/memberEditJson.do", new MemberEditJson());
		
		menu.put("/chartForm.do", new ChartFormControl());
		menu.put("/chartData.do", new ChartDataControl());
		menu.put("/calendar.do", new CalendarForm());
		
		menu.put("/eventForm.do", new EventForm());
		menu.put("/eventList.do", new EventListControl());
		menu.put("/addEvent.do", new AddEventControl());
		menu.put("/removeEvent.do", new RemoveEventControl());
		
		//게시판
		menu.put("/boardList.do", new boardListControl());
		menu.put("/boardselect.do", new boardselectControl());
		
		//댓글 (Ajax  처리를 위한 컨트롤)
		menu.put("/replyList.do", new ReplyListControl());
		menu.put("/getReply.do", new ReplyControl());
		menu.put("/addReply.do", new AddReplyControl());
		menu.put("/editReply.do", new EditReplyControl());
		menu.put("/delReply.do", new DelReplyControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String page = uri.substring(contextPath.length());
		System.out.println(page);
		
		Control control = menu.get(page);
		String viewPage = control.exec(req, resp);
		
		if(viewPage.endsWith(".jsp")) {
			viewPage = "/WEB-INF/views/" + viewPage;
		} else if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage); // 
			return;
		} else if (viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=utf-8");
			resp.getWriter().print(viewPage.substring(0, viewPage.length() -5));
			return;
		}
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
}
