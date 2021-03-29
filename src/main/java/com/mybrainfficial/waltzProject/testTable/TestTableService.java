package com.mybrainfficial.waltzProject.testTable;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TestTableService {
	@Resource
	private TestTableDAO testTableDAO;

	public List<TestTableVO> getTestTableList(final TestTableVO vo) throws DataAccessException {
		return testTableDAO.getTestTableList(vo);
	}

	public void insertTestTable(final TestTableVO vo) throws DataAccessException {
		testTableDAO.insertTestTable(vo);
	}

	public void updateTestTable(final TestTableVO vo) throws DataAccessException {
		testTableDAO.updateTestTable(vo);
	}

	public void deleteTestTable(final TestTableVO vo) throws DataAccessException {
		testTableDAO.deleteTestTable(vo);
	}
}