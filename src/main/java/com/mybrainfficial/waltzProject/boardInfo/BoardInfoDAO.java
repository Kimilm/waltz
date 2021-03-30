package com.mybrainfficial.waltzProject.boardInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class BoardInfoDAO {
	@Autowired
	private SqlSession sqlsession;
	
	private static final String NS = BoardInfoDAO.class.getPackage().getName() + ".";
	
	public List<BoardInfoVO> selectListBoardInfo(final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.selectList(NS + "selectListBoardInfo", vo);
	}
	
	public List<PostVO> selectListPost(final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.selectList(NS + "selectListPost", vo);
	}
}
