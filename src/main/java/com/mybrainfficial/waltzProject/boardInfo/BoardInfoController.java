package com.mybrainfficial.waltzProject.boardInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.mybrainfficial.waltzProject.ResultVO;
import com.mybrainfficial.waltzProject.common.commonUtil.MessageUtil;
import com.mybrainfficial.waltzProject.menuInfo.MenuInfoService;
import com.mybrainfficial.waltzProject.menuInfo.MenuInfoVO;
import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Controller
@RequestMapping
public class BoardInfoController {

	@Autowired
	BoardInfoService boardInfoService;
	
	/* paging total count */
	@Autowired
	private ServletContext application;
	
	@Autowired
	private MenuInfoService menuInfoService;
	
	@PostConstruct
	private void setPostCount() {
		List<MenuInfoVO> menuList = menuInfoService.selectListMenuInfo("S");
		
		Map<String, Integer> postCount = new HashMap<>();
		
		for(MenuInfoVO vo : menuList) {
			Integer count = boardInfoService.selectBoardCount(vo.getMenuCd());
			postCount.put(vo.getMenuCd(), count);
		}
		
		application.setAttribute("postCount", postCount);
		
		//log
		System.out.println("#################### post count in application scope ####################");
	}
	/* paging total count */

	/* 메인 화면 카드뷰 */
	@RequestMapping("/main/{menuCd}")
	@ResponseBody
	public List<BoardInfoVO> getBoardInfoList(@PathVariable("menuCd") String menuCd) {
		/*
		 * BoardInfoVO vo = new BoardInfoVO(); vo.setBrdCd(menuCd);
		 * 
		 * return getBoardInfoList(vo);
		 */
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("menuCd", menuCd);
		queryMap.put("limit", 10);	// 메인에는 최근 10개 항목만 보여줌
		queryMap.put("offset", 0);
		
		return boardInfoService.selectListBoardInfo(queryMap);
	}

	/*
	 * @ResponseBody public List<BoardInfoVO> getBoardInfoList(BoardInfoVO vo) {
	 * return boardInfoService.selectListBoardInfo(vo); }
	 */
	/*
	 * @ResponseBody public List<BoardInfoVO> getBoardInfoList(final Map<String,
	 * Object> queryMap) { return boardInfoService.selectListBoardInfo(queryMap); }
	 */

	/* 게시글 */
	@RequestMapping(value = "/getPostList/{menuCd}", method = RequestMethod.GET)
	@ResponseBody
	// public List<PostVO> getPostList (@PathVariable("menuCd") String menuCd) {
	public List<BoardInfoVO> getPostList(@PathVariable("menuCd") String menuCd, PageAndSearchVO ps) {
		/*
		 * BoardInfoVO vo = new BoardInfoVO(); vo.setBrdCd(menuCd);
		 * 
		 * // return boardInfoService.selectListPost(vo); return
		 * boardInfoService.selectListBoardInfo(vo);
		 */
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("menuCd", menuCd);
		
		if (ps.getSearch() != null) {
			System.out.println(ps.getSearch());		// log
			
			queryMap.put("search", '%' + ps.getSearch() + '%');
		}
		
		Integer limit = 20;	// 게시글 20개씩 페이징 처리
		queryMap.put("limit", limit);
		
		if (ps.getPage() != null) {
			Integer offset = ps.getPage() - 1;
			offset *= limit;
			queryMap.put("offset", offset);
		} else {
			Integer offset = 0;
			queryMap.put("offset", offset);
		}
		
		return boardInfoService.selectListBoardInfo(queryMap);
	}

	/* read */
	@Transactional
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public String getPost(@CookieValue("view") String cookie, HttpServletResponse response, @PathVariable("postId") String postId, PageAndSearchVO ps, Model model) {
		BoardInfoVO post = new BoardInfoVO();
		post.setPostId(Integer.parseInt(postId));
		
		if (!cookie.contains("/" + postId + "/")) {
			cookie += postId + "/";
			// ++hitCnt
			boardInfoService.updateBoardInfoHits(post);
			response.addCookie(new Cookie("view", cookie));
		}
		
		post = boardInfoService.selectBoardinfo(post);
		
		model.addAttribute("post", post);

		return "post";
	}
	
	/* create */
	@RequestMapping(value = "/bbs/{menuCd}/create")
	public String newPost(@PathVariable("menuCd") String menuCd, Model model) {
		model.addAttribute("menuCd", menuCd);	
		application.setAttribute(menuCd, (Integer)application.getAttribute(menuCd) + 1);
		
		return "newPostForm";
	}

	@RequestMapping(value = "/insertPost", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO insertPost(BoardInfoVO vo, HttpSession session) {
		if (vo.getPostSubject() == null)
			return MessageUtil.getFailCode();

		UserInfoVO user = (UserInfoVO) session.getAttribute("login");
		vo.setWrtrId(user.getUserId());
		vo.setCrtId(user.getUserId());

		int result = boardInfoService.insertBoardInfo(vo);
		return MessageUtil.getMessage(result);
	}

	/* update */
	@RequestMapping(value = "/updatePost/{postId}")
	public String updatePost(@PathVariable("postId") String postId, Model model) {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setPostId(Integer.parseInt(postId));
		vo = boardInfoService.selectBoardinfo(vo);

		model.addAttribute("post", vo);

		return "updatePostForm";
	}

	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO updatePost(BoardInfoVO vo, HttpSession session) {
		if (vo.getPostSubject() == null)
			return MessageUtil.getFailCode();

		UserInfoVO user = (UserInfoVO) session.getAttribute("login");
		vo.setUpdtId(user.getUserId());

		int result = boardInfoService.updateBoardInfo(vo);
		return MessageUtil.getMessage(result);
	}
	
	@RequestMapping(value="/setReplyYn", method=RequestMethod.POST)
	@ResponseBody
	public ResultVO setReplyYn(BoardInfoVO vo) {
		int result = boardInfoService.updateBoardInfoReplyYn(vo);
		return MessageUtil.getMessage(result);
	}

	/* delete */
	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO deletePost(BoardInfoVO vo, HttpSession session) {
		boardInfoService.deleteBoardInfo(vo);
		application.setAttribute(vo.getBrdCd(), (Integer)application.getAttribute(vo.getBrdCd()) - 1);
		
		return MessageUtil.getSuccessCode();
	}
}
