package com.cws.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cws.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void memberJoin(Map<String, String> joinMap) throws Exception {
		sqlSession.insert("member.insertMember", joinMap);
		
	}

	@Override
	public MemberVO loginCheck(Map<String, String> loginMap) throws Exception {		
		return sqlSession.selectOne("member.selectLoginCheck", loginMap);
	}

	@Override
	public MemberVO selectMemberNum(int member_num) throws Exception {	
		return sqlSession.selectOne("member.selectMemberNum", member_num);
	}

	@Override
	public int memberIdCheck(String member_id) throws Exception {
		return sqlSession.selectOne("member.memberIdCheck",member_id);
	}

	@Override
	public void updateMember(Map<String, Object> memberMap) throws Exception {
		sqlSession.update("member.updateMember", memberMap);
	}

}
