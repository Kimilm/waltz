package com.mybrainfficial.waltzProject.menuInfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Service
public class MenuInfoService {
	
	@Resource
	private MenuInfoDAO menuInfoDAO;
	
	public List<MenuInfoVO> selectListMenuInfo(final String menuTp) throws DataAccessException {
		return menuInfoDAO.selectListMenuInfo(menuTp);
	}
	
	public List<MenuInfoVO> selectListMenuInfoByUserInfoM(UserInfoVO vo) throws DataAccessException {
		return menuInfoDAO.selectListMenuInfoByUserInfoM(vo);
	}
	
	public List<MenuInfoVO> selectListMenuInfoByUserInfoS(UserInfoVO vo) throws DataAccessException {
		return menuInfoDAO.selectListMenuInfoByUserInfoS(vo);
	}
}
