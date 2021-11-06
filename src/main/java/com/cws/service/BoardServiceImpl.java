package com.cws.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cws.dao.BoardDAO;
import com.cws.domain.BoardVO;
import com.cws.domain.Criteria;
import com.cws.domain.NoticeVO;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDao;

	@Override
	public List<BoardVO> selectBoard(Criteria cri) throws Exception {		
		return boardDao.selectBoard(cri);
	}
	
	@Override
	public int listCount() throws Exception {		
		return boardDao.listCount();
	}

	@Override
	public void insertBoard(Map<String, Object> boardmap) throws Exception {
		boardDao.insertBoard(boardmap);
		
	}

	@Override
	public BoardVO selectBoardTitle(int board_num) throws Exception {
		return boardDao.selectBoardTitle(board_num);
	}

	@Override
	public void deleteBoard(int board_num) throws Exception {
		boardDao.deleteBoard(board_num);
	}

	@Override
	public void updateBoard(Map<String, Object> boardmap) throws Exception {
		boardDao.updateBoard(boardmap);
		
	}

	@Override
	public List<NoticeVO> allNoticeList() throws Exception {
		return boardDao.allNoticeList();
	}

	
}
