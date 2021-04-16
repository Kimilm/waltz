package com.mybrainfficial.waltzProject.boardInfo;

import java.util.List;

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
	public List<BoardInfoVO> getBoardInfoList (@PathVariable("menuCd") String menuCd) {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setBrdCd(menuCd);

		return getBoardInfoList(vo);
	}
	
	@ResponseBody
	public List<BoardInfoVO> getBoardInfoList(BoardInfoVO vo) {
		return boardInfoService.selectListBoardInfo(vo);
	}
	
	/* 게시글 */
	@RequestMapping(value = "/getPostList/{menuCd}")
	@ResponseBody
	//public List<PostVO> getPostList (@PathVariable("menuCd") String menuCd) {
	public List<BoardInfoVO> getPostList (@PathVariable("menuCd") String menuCd) {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setBrdCd(menuCd);
		
//		return boardInfoService.selectListPost(vo);
		return boardInfoService.selectListBoardInfo(vo);
	}
	
	/* read */
	@RequestMapping(value = "/getPost/{postId}", method = RequestMethod.GET)
	public String getPost(@PathVariable("postId") String postId, TestBoardUtilVO util, Model model) {
		BoardInfoVO post = new BoardInfoVO();
		post.setPostId(Integer.parseInt(postId));
		post = boardInfoService.selectBoardinfo(post);
		
		/* param test */
		System.out.println(util.getSearch());
		System.out.println(util.getPage());
		
		model.addAttribute("post", post);
		model.addAttribute("menuCd", post.getBrdCd());
		
		return "post";
	}
	
	/* create */
	@RequestMapping(value="/bbs/{menuCd}/create")
	public String newPost(@PathVariable("menuCd") String menuCd, Model model) {
		model.addAttribute("menuCd", menuCd);
		return "newPostForm";
	}
	
	@RequestMapping(value = "/insertPost", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO insertPost (BoardInfoVO vo, HttpSession session) {
		if(vo.getPostSubject() == null)
			return MessageUtil.getFailCode();
		
		UserInfoVO  user = (UserInfoVO) session.getAttribute("login");
		vo.setWrtrId(user.getUserId());
		vo.setCrtId(user.getUserId());
		
		int result = boardInfoService.insertBoardInfo(vo);
		return MessageUtil.getMessage(result);
	}
	
	/* update */
	@RequestMapping(value="/updatePost/{postId}")
	public String updatePost(@PathVariable("postId") String postId, Model model) {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setPostId(Integer.parseInt(postId));
		vo = boardInfoService.selectBoardinfo(vo);
		
		model.addAttribute("post", vo);
		
		return "updatePostForm";
	}
	
	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO updatePost (BoardInfoVO vo, HttpSession session) {
		if(vo.getPostSubject() == null)
			return MessageUtil.getFailCode();
		
		UserInfoVO  user = (UserInfoVO) session.getAttribute("login");
		vo.setUpdtId(user.getUserId());
		
		int result = boardInfoService.updateBoardInfo(vo);
		return MessageUtil.getMessage(result);
	}
	
	/* delete */
	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO deletePost (BoardInfoVO vo, HttpSession session) {
		boardInfoService.deleteBoardInfo(vo);
		return MessageUtil.getSuccessCode();
	}
}
