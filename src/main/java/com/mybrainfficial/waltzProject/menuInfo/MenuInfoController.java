package com.mybrainfficial.waltzProject.menuInfo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Controller
public class MenuInfoController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private MenuInfoService menuInfoService;

	@RequestMapping("/setMenu")
	public String getMenuList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("menuMt") == null) {
			List<MenuInfoVO> menuMt = menuInfoService.selectListMenuInfoByUserInfoM((UserInfoVO) session.getAttribute("login"));
			List<MenuInfoVO> menuDt = menuInfoService.selectListMenuInfoByUserInfoS((UserInfoVO) session.getAttribute("login"));
			
//			session.setAttribute("menuMt", menuMt);
//			session.setAttribute("menuDt", menuDt);
			
			/* ver.2 map type for search */
			/* 나중에 Stream으로 바꿀것 */
			Map<String, MenuInfoVO> mtMap = new LinkedHashMap<>();
			Map<String, MenuInfoVO> dtMap = new LinkedHashMap<>();
			
			for(MenuInfoVO vo : menuMt)
				mtMap.put(vo.getMenuCd(), vo);

			
			for(MenuInfoVO vo : menuDt)
				dtMap.put(vo.getMenuCd(), vo);
			
			session.setAttribute("menuMt", mtMap);
			session.setAttribute("menuDt", dtMap);
		}
		
		return "redirect:/user/main";
	}
	
	/* 게시판 */
	@RequestMapping("/bbs/{menuCd}")
	public String getBoard (@PathVariable("menuCd") String menuCd, Model model) {
		//MenuInfoVO menu = MenuInfoService.getMenuInfo().get(menuCd);
		
		/* print menuNm */
		model.addAttribute("menuCd", menuCd);
		
		return "board";
	}
	
	/* application scope init */
	@PostConstruct
	public void setAuthMappInfoToApplicationScope() {
		List<AuthMappInfoVO> authMappInfoList = menuInfoService.selectListAuthMappInfo();
		Map<String, AuthMappInfoVO> authMappInfoMap = new HashMap<>();
		
		for(AuthMappInfoVO vo : authMappInfoList)
			authMappInfoMap.put(vo.getMenuCd(), vo);
		
		application.setAttribute("authMappInfo", authMappInfoMap);
		logger.info("======================== init menuInfo in ApplicationScope ================");
	}
}
