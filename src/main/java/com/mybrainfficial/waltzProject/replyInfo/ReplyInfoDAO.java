package com.mybrainfficial.waltzProject.replyInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mybrainfficial.waltzProject.boardInfo.BoardInfoVO;


@Repository
public class ReplyInfoDAO {
	@Autowired
	private SqlSession sqlsession;
	
	private static final String NS = ReplyInfoDAO.class.getPackage().getName() + ".";
	
	public List<ReplyInfoVO> selectReplyInfo(final BoardInfoVO vo) throws DataAccessException {
		return this.sqlsession.selectList(NS + "selectReplyInfo", vo);
	}
}
