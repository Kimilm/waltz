package com.mybrainfficial.waltzProject.menuInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Service
public class MenuInfoService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private MenuInfoDAO menuInfoDAO;
	
	private static Map<String, MenuInfoVO> menuInfo = new HashMap<>();
	
//	메뉴 리스트는 로그인시 세션에 저장함
//	@PostConstruct
//	public void setMenuInfo() { 
//		List<MenuInfoVO> menuList = menuInfoDAO.selectMenuInfoAll();
//		
//		for(MenuInfoVO vo : menuList) {
//			MenuInfoService.menuInfo.put(vo.getMenuCd(), vo);
//		}
//		
//		logger.info("======================== init menuInfo in memory ================");
//	}
//	
//	public static Map<String, MenuInfoVO> getMenuInfo() { return menuInfo; }
	
	public List<MenuInfoVO> selectListMenuInfo(final String menuTp) throws DataAccessException {
		return menuInfoDAO.selectListMenuInfo(menuTp);
	}
	
	public List<MenuInfoVO> selectListMenuInfoByUserInfoM(final UserInfoVO vo) throws DataAccessException {
		return menuInfoDAO.selectListMenuInfoByUserInfoM(vo);
	}
	
	public List<MenuInfoVO> selectListMenuInfoByUserInfoS(final UserInfoVO vo) throws DataAccessException {
		return menuInfoDAO.selectListMenuInfoByUserInfoS(vo);
	}
	
	/* AuthMappInfo */
	public List<AuthMappInfoVO> selectListAuthMappInfo() throws DataAccessException {
		return menuInfoDAO.selectListAuthMappInfo();
	}
}
