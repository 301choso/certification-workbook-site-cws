package com.cws.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cws.dao.MyPageDAO;
import com.cws.domain.BoardVO;
import com.cws.domain.MypageVO;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDAO myPageDAO;

	@Override
	public void insertMypage(MypageVO mypageVO) throws Exception {
		myPageDAO.insertMypage(mypageVO);
	}

	@Override
	public List<MypageVO> selectMypage() throws Exception {
		return myPageDAO.selectMypage();
	}

	@Override
	public void deleteMypage(int mypage_num) throws Exception {
		myPageDAO.deleteMypage(mypage_num);
	}

	@Override
	public boolean findMypageList(MypageVO mypageVO) throws Exception {
		return myPageDAO.findMypageList(mypageVO);
	}

	@Override
	public List<BoardVO> selectMyBoard(int member_num) throws Exception {
		return  myPageDAO.selectMyBoard(member_num);
	}
}
