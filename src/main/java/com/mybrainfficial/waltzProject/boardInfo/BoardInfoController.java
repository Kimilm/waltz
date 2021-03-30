package com.mybrainfficial.waltzProject.boardInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardInfoController {
	
	@Autowired
	BoardInfoService boardInfoService;
	
	@RequestMapping("/bbs/{menuCd}")
	@ResponseBody
	public List<PostVO> getPostList (@PathVariable("menuCd") String menuCd) {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setBrdCd(menuCd);
		
		return boardInfoService.selectListPost(vo);
	}
	
	@ResponseBody
	public List<BoardInfoVO> getBoardInfoList(BoardInfoVO vo) {
		return boardInfoService.selectListBoardInfo(vo);
	}
	
	@RequestMapping("/bbs/notice")
	public List<BoardInfoVO> getNoticeList () {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setBrdCd("S001");

		return getBoardInfoList(vo);
	}
}
