package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.annotation.MapMethodProcessor;

import co.micol.prj.MainCommand;
import co.micol.prj.common.Command;
import co.micol.prj.member.command.AjaxIdCheck;
import co.micol.prj.member.command.AjaxMemberSearchList;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> map = new HashMap<>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 호출하는 이름들의 집합
		map.put("/main.do", new MainCommand()); // 처음들어오는 페이지
		map.put("/memberLoginForm.do", new MemberLoginForm()); //로그인 화면
		map.put("/memberLogin.do", new MemberLogin());  // 로그인처리
		map.put("/memberLogout.do", new MemberLogout()); // 로그아웃 처리
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입 화면
		map.put("/ajaxIdCheck.do", new AjaxIdCheck()); // ajax 아이디 중복체크 처리
		map.put("/memberList.do", new MemberList()); // 멤버 목록 보기
		map.put("/ajaxMemberSearchList.do", new AjaxMemberSearchList()); //멤버 검색
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청을 분석하고, 적절한 Command 선택 및 실행, 결과를 돌려줄 곳을 정하는 곳
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String contextpath = request.getContextPath();
		String page = uri.substring(contextpath.length());
		
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("Ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage += ".tiles";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}

}
