package com.mybrainfficial.waltzProject.menuInfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Controller
public class MenuInfoController {
	
	@Autowired
	private MenuInfoService menuInfoService;

	@RequestMapping("/setMenu")
	public String getMenuList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("menuMt") == null) {
			List<MenuInfoVO> menuMt = menuInfoService.selectListMenuInfoByUserInfoM((UserInfoVO) session.getAttribute("login"));
			List<MenuInfoVO> menuDt = menuInfoService.selectListMenuInfoByUserInfoS((UserInfoVO) session.getAttribute("login"));
			
			session.setAttribute("menuMt", menuMt);
			session.setAttribute("menuDt", menuDt);
		}
		
		return "redirect:/user/main";
	}
	
	/* 게시판 */
	@RequestMapping("/bbs/{menuCd}")
	public String getBoard (@PathVariable("menuCd") String menuCd, Model model) {
		MenuInfoVO menu = MenuInfoService.getMenuInfo().get(menuCd);
		
		/* print menuNm */
		model.addAttribute("menu", menu);
		
		return "board";
	}
}
