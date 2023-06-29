package com.yedam.calendar.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.calendar.service.CalendarService;
import com.yedam.calendar.service.CalendarServiceImpl;
import com.yedam.calendar.vo.CalendarVO;
import com.yedam.common.Control;

public class EventListControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		CalendarService service = new CalendarServiceImpl();
		List<CalendarVO> list = service.events();
		//[{"title":"해외여행","start":"2023323232","end":"231213231231"}.....]
		Gson gson = new GsonBuilder().create(); 
		String json = gson.toJson(list);
		
		return json + ".json";
	}

}
