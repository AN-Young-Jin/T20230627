package com.yedam.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String prodCode;
	private String prodName;
	private String prodDesc;
	private int price;
	private int offPrice;
	private int likeIt;
	private String prodImage;
}
