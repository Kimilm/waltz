package com.mybrainfficial.waltzProject.menuInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Repository
public class MenuInfoDAO {
	@Autowired
	private SqlSession sqlsession;
	
	private static final String NS = MenuInfoDAO.class.getPackage().getName() + ".";
	
	public List<MenuInfoVO> selectListMenuInfo(final String menuTp) throws DataAccessException {
		return this.sqlsession.selectList(NS + "selectListMenuInfo", menuTp);
	}
	
	public List<MenuInfoVO> selectListMenuInfoByUserInfoM(final UserInfoVO vo) throws DataAccessException {
		return this.sqlsession.selectList(NS + "selectListMenuInfoByUserInfoM", vo);
	}
	
	public List<MenuInfoVO> selectListMenuInfoByUserInfoS(final UserInfoVO vo) throws DataAccessException {
		return this.sqlsession.selectList(NS + "selectListMenuInfoByUserInfoS", vo);
	}
}
