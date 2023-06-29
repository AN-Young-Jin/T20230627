package com.yedam.board.vo;

import java.util.Date;

import lombok.Data;
@Data
public class BoardVO {
	private long brdNo;
	private String brdTitle;
	private String brdContent;
	private String brdWriter;
	private Date createDate;
	private int clickCnt;
}
