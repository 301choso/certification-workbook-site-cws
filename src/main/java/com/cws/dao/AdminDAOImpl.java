package com.cws.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cws.domain.MemberVO;
import com.cws.domain.NoticeVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MemberVO> adminMemberList() throws Exception {
		return sqlSession.selectList("member.selectMember");
	}

	@Override
	public List<NoticeVO> adminNoticeList() throws Exception {
		return sqlSession.selectList("notice.selectNotice");
	}

	@Override
	public void addNotice(Map<String, String> noticeMap) throws Exception {
		sqlSession.insert("notice.insertNotice", noticeMap);
		
	}

	@Override
	public void updateNotice(Map<String, Object> noticeMap) throws Exception {
		sqlSession.update("notice.updateNotice", noticeMap);
	}

	@Override
	public NoticeVO selectNoticeTitle(int notice_num) throws Exception {
		return sqlSession.selectOne("notice.selectNoticeTitle", notice_num);
	}

	@Override
	public void deleteNotice(int notice_num) throws Exception {
		sqlSession.delete("notice.deleteNotice",notice_num);
	}

	@Override
	public MemberVO selectMemberNum(int member_num) throws Exception {
		return sqlSession.selectOne("member.selectMemberNum", member_num);
	}

	@Override
	public void updateMember(Map<String, Object> memberMap) throws Exception {
		sqlSession.update("member.updateMember",memberMap);
	}
	
}
