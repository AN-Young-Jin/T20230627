package com.yedam.member.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberAddControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		// uid uname upw uphone uaddr ubirth
		String uid = req.getParameter("uid");
		String upw = req.getParameter("upw");
		String uname = req.getParameter("uname");
		String uphone = req.getParameter("uphone");
		String uaddr = req.getParameter("uaddr");
		String ubirth = req.getParameter("ubirth");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setUserId(uid);
		vo.setUserPw(upw);
		vo.setUserName(uname);
		vo.setUserPhone(uphone);
		vo.setUserAddr(uaddr);
		//vo.setUserImg("");
		try {
			vo.setUserBirth(sdf.parse(ubirth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		service.addMember(vo);
		//MemberVo json문자열 반환
		Gson gson = new GsonBuilder().create();
		return gson.toJson(vo) + ".json";
	}

}
