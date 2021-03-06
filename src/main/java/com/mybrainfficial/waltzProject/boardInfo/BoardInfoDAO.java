package com.mybrainfficial.waltzProject.boardInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class BoardInfoDAO {
	@Autowired
	private SqlSession sqlsession;
	
	private static final String NS = BoardInfoDAO.class.getPackage().getName() + ".";
	
	public Integer selectBoardCount(final String brdCd) throws DataAccessException {
		return this.sqlsession.selectOne(NS + "selectBoardCount", brdCd);
	}
	
	public BoardInfoVO selectBoardInfo(final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.selectOne(NS + "selectBoardInfo", vo);
	}
	
	/*
	 * public List<BoardInfoVO> selectListBoardInfo(final BoardInfoVO vo) throws
	 * DataAccessException { return this.sqlsession.selectList(NS +
	 * "selectListBoardInfo", vo); }
	 */
	public List<BoardInfoVO> selectListBoardInfo(final Map<String, Object> queryMap) throws DataAccessException {
		return this.sqlsession.selectList(NS + "selectListBoardInfo", queryMap);
	}
	
	public List<PostVO> selectListPost(final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.selectList(NS + "selectListPost", vo);
	}
	
	public int insertBoardInfo (final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.insert(NS + "insertBoardInfo", vo);
	}
	
	public int updateBoardInfo (final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.update(NS + "updateBoardInfo", vo);
	}
	
	public int updateBoardInfoHits (final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.update(NS + "updateBoardInfoHits", vo);
	}
	
	public int updateBoardInfoReplyYn (final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.update(NS + "updateBoardInfoReplyYn", vo);
	}
	
	public int deleteBoardInfo (final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.update(NS + "deleteBoardInfo", vo);
	}
}
