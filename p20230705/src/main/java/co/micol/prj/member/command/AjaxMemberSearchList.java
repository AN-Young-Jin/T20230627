package co.micol.prj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberSearchList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO ajax 멤버 검색
		MemberService service = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper(); // Json 객체로 돌려주기 위해
		
		String key = request.getParameter("key");
		String val = request.getParameter("val");
	
		list = service.memberSelectList(key, val);
		
		String str = "Ajax:";
		try {
			str += mapper.writeValueAsString(list); // Json 타입의 문자열로 변환
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return str;
	}

}
