package com.mybrainfficial.waltzProject.menuInfo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mybrainfficial.waltzProject.boardInfo.BoardInfoVO;
import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Service
public class MenuInfoService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private MenuInfoDAO menuInfoDAO;
	
	private static List<MenuInfoVO> menuInfo;
	
	@PostConstruct
	public void setMenuInfo() { 
		this.menuInfo = menuInfoDAO.selectMenuInfoAll();
		logger.info("======================== init menuInfo in memory ================");
	}
	
	public static List<MenuInfoVO> getMenuInfo() { return menuInfo; }
	
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
