package com.yedam.member.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberInfoJson implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String uid = req.getParameter("uid");
		String ubirth = req.getParameter("ubirth");
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = service.getMember(uid);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date a = vo.getUserBirth();
		
//		try {
//			Date date = sdf.parse(ubirth);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		vo.setUserBirth(sdf.parse(uid));
		
		Gson gson = new GsonBuilder().create();
		return gson.toJson(vo) + ".json";
		
	}

}
