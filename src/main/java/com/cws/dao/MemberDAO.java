package com.cws.dao;

import java.util.Map;

import com.cws.domain.MemberVO;

public interface MemberDAO {

	public void memberJoin(Map<String, String> joinMap) throws Exception;

	public MemberVO loginCheck(Map<String, String> loginMap) throws Exception;

	public MemberVO selectMemberNum(int member_num) throws Exception;

	public int memberIdCheck(String member_id) throws Exception;

	public void updateMember(Map<String, Object> memberMap) throws Exception;

	public int selectMemberEmail(String member_email) throws Exception;

}
