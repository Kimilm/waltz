package com.mybrainfficial.waltzProject.userInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


@Repository
public class UserInfoDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NS = UserInfoDAO.class.getPackage().getName() + ".";

	// ȸ������ ��ȸ
	public UserInfoVO selectUserInfo(final UserInfoVO vo) throws DataAccessException {
		return this.sqlSession.selectOne(NS + "selectUserInfo", vo);
	}

	// ȸ������ ��� (�ű� ȸ������)
	public int insertUserInfo(final UserInfoVO vo) throws DataAccessException {
		return this.sqlSession.insert(NS + "insertUserInfo", vo);
	}

	// ȸ������ ����
	public int updateUserInfo(final UserInfoVO vo) throws DataAccessException {
		return this.sqlSession.update(NS + "updateUserInfo", vo);
	}

	// ȸ�� ����(Ż��)
	public int deleteUserInfo(final UserInfoVO vo) throws DataAccessException {
		return this.sqlSession.delete(NS + "deleteUserInfo", vo);
	}

}
