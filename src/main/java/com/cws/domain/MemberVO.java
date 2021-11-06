package com.cws.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private int member_num;
	private String member_id;
	private String member_pw;
	private String member_email;
	private Date member_join_date;
	private String member_member_yn;
	
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public Date getMember_join_date() {
		return member_join_date;
	}
	public void setMember_join_date(Date member_join_date) {
		this.member_join_date = member_join_date;
	}
	public String getMember_member_yn() {
		return member_member_yn;
	}
	public void setMember_member_yn(String member_member_yn) {
		this.member_member_yn = member_member_yn;
	}

}
