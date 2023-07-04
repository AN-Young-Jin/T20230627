package com.yedam.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProdInfoControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		String no = req.getParameter("pid");
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.getProduct(no);
		
		
		List<ProductVO> list = service.likeList();
		
		
		req.setAttribute("list", vo);
		req.setAttribute("like", list);
		
		return "product/prodInfo.tiles";
	}

}
