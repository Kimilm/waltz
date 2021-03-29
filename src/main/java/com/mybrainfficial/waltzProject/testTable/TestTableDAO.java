package com.mybrainfficial.waltzProject.testTable;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


@Repository
public class TestTableDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// end must be point .
	private static final String NS = TestTableDAO.class.getPackage().getName() + ".";

	public List<TestTableVO> getTestTableList(final TestTableVO vo) throws DataAccessException {
		return this.sqlSession.selectList(NS + "getTestTableList", vo);
	}

	public void insertTestTable(final TestTableVO vo) throws DataAccessException {
		this.sqlSession.insert(NS + "insertTestTable", vo);
	}

	public void updateTestTable(final TestTableVO vo) throws DataAccessException {
		this.sqlSession.insert(NS + "updateTestTable", vo);
	}

	public void deleteTestTable(final TestTableVO vo) throws DataAccessException {
		this.sqlSession.insert(NS + "deleteTestTable", vo);
	}

}