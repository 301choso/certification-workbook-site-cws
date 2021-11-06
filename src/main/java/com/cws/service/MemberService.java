package com.cws.service;

import java.util.Map;

import com.cws.domain.MemberVO;

public interface MemberService {
	
	public void memberJoin(Map<String, String> joinMap) throws Exception;

	public MemberVO loginCheck(Map<String, String> loginMap) throws Exception;

	public MemberVO selectMemberNum(int member_num) throws Exception;

	public int memberIdCheck(String member_id) throws Exception;

	public void updateMember(Map<String, Object> memberMap) throws Exception;
	
}
