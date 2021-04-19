package com.mybrainfficial.waltzProject.boardInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	/* 메인 화면 카드뷰 */
	@RequestMapping("/main/{menuCd}")
	public List<BoardInfoVO> getBoardInfoList(@PathVariable("menuCd") String menuCd) {
		/*
		 * BoardInfoVO vo = new BoardInfoVO(); vo.setBrdCd(menuCd);
		 * 
		 * return getBoardInfoList(vo);
		 */
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("menuCd", menuCd);
		
		return getBoardInfoList(queryMap);
	}

	/*
	 * @ResponseBody public List<BoardInfoVO> getBoardInfoList(BoardInfoVO vo) {
	 * return boardInfoService.selectListBoardInfo(vo); }
	 */
	@ResponseBody
	public List<BoardInfoVO> getBoardInfoList(final Map<String, Object> queryMap) {
		return boardInfoService.selectListBoardInfo(queryMap);
	}

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
		
		Integer limit = 40;
		queryMap.put("limit", limit);
		
		if (ps.getPage() != null) {
			System.out.println(ps.getPage());		// log
			
			Integer offset = ps.getPage() - 1;
			offset *= limit;
			queryMap.put("offset", offset);
		} else {
			System.out.println(ps.getPage());		// log
			
			Integer offset = 0;
			queryMap.put("offset", offset);
		}
		
		return boardInfoService.selectListBoardInfo(queryMap);
	}

	/* read */
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public String getPost(@PathVariable("postId") String postId, PageAndSearchVO ps, Model model) {
		BoardInfoVO post = new BoardInfoVO();
		post.setPostId(Integer.parseInt(postId));
		post = boardInfoService.selectBoardinfo(post);
		
		model.addAttribute("post", post);
		model.addAttribute("menuCd", post.getBrdCd());

		return "post";
	}
	
	/* create */
	@RequestMapping(value = "/bbs/{menuCd}/create")
	public String newPost(@PathVariable("menuCd") String menuCd, Model model) {
		model.addAttribute("menuCd", menuCd);
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

	/* delete */
	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO deletePost(BoardInfoVO vo, HttpSession session) {
		boardInfoService.deleteBoardInfo(vo);
		return MessageUtil.getSuccessCode();
	}
}
