package com.cws.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cws.domain.BoardVO;
import com.cws.domain.Criteria;
import com.cws.domain.NoticeVO;
@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> selectBoard(Criteria cri) throws Exception {		
		return sqlSession.selectList("board.selectBoard", cri);		
	}
	
	@Override
	public int listCount() throws Exception {
		return sqlSession.selectOne("board.listCount");	
	}

	@Override
	public void insertBoard(Map<String, Object> boardmap) throws Exception {
		sqlSession.insert("board.insertBoard",boardmap);
	}
	
	@Override
	public BoardVO selectBoardTitle(int board_num) throws Exception {
		BoardVO boardVO =  (BoardVO)sqlSession.selectOne("board.selectBoardTitle",board_num);
		return boardVO;
	}

	@Override
	public void deleteBoard(int board_num) throws Exception {
		sqlSession.delete("board.deleteBoard",board_num);
		
	}

	@Override
	public void updateBoard(Map<String, Object> boardmap) throws Exception {
		sqlSession.update("board.updateBoard",boardmap);
		
	}

	@Override
	public List<NoticeVO> allNoticeList() throws Exception {
		return sqlSession.selectList("notice.selectNotice");
	}

	@Override
	public NoticeVO selectNoticeView(int notice_num) throws Exception {
		return sqlSession.selectOne("notice.selectNoticeTitle",notice_num);
	}


}
