package com.cws.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cws.dao.MemberDAO;
import com.cws.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void memberJoin(Map<String, String> joinMap) throws Exception {
		memberDAO.memberJoin(joinMap);
		
	}

	@Override
	public MemberVO loginCheck(Map<String, String> loginMap) throws Exception {
		return memberDAO.loginCheck(loginMap);
	}

	@Override
	public MemberVO selectMemberNum(int member_num) throws Exception {
		return memberDAO.selectMemberNum(member_num);
	}

	@Override
	public int memberIdCheck(String member_id) throws Exception {
		return memberDAO.memberIdCheck(member_id);
	}

	@Override
	public void updateMember(Map<String, Object> memberMap) throws Exception {
		memberDAO.updateMember(memberMap);
	}
	
	
}
