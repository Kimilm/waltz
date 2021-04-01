package com.mybrainfficial.waltzProject.boardInfo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybrainfficial.waltzProject.menuInfo.MenuInfoService;
import com.mybrainfficial.waltzProject.menuInfo.MenuInfoVO;

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
	
	@RequestMapping(value = "/post/{postId}")
	public String getPost(@PathVariable("postId") String postId, Model model) {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setPostId(Integer.parseInt(postId));
		
		model.addAttribute(boardInfoService.selectBoardinfo(vo));
		
		return "post";
	}
}
