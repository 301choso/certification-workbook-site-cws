package com.cws.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cws.domain.BoardVO;
import com.cws.domain.MypageVO;

@Repository
public class MyPageDAOImpl implements MyPageDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertMypage(MypageVO mypageVO) throws Exception {
		sqlSession.insert("mypage.insertMypage", mypageVO);
	}

	@Override
	public List<MypageVO> selectMypage() throws Exception {
		return sqlSession.selectList("mypage.selectMypage");
	}

	@Override
	public void deleteMypage(int mypage_num) throws Exception {
		sqlSession.delete("mypage.deleteMypage",mypage_num);
	}

	@Override
	public boolean findMypageList(MypageVO mypageVO) throws Exception {
		String result = sqlSession.selectOne("mypage.selectCountInMypage",mypageVO);
		return Boolean.parseBoolean(result);
	}

	@Override
	public List<BoardVO> selectMyBoard(int member_num) throws Exception {
		return sqlSession.selectList("board.selectMyBoard", member_num);
	}
	
}
