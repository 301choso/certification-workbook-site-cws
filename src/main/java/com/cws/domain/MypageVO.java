package com.cws.domain;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class MypageVO {

	private int mypage_num;
	private Date mypage_date;
	private int member_num;
	private int board_num;
	
	public int getMypage_num() {
		return mypage_num;
	}
	public void setMypage_num(int mypage_num) {
		this.mypage_num = mypage_num;
	}
	public Date getMypage_date() {
		return mypage_date;
	}
	public void setMypage_date(Date mypage_date) {
		this.mypage_date = mypage_date;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	
}
