package com.mybrainfficial.waltzProject.replyInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybrainfficial.waltzProject.boardInfo.BoardInfoVO;

@Controller
public class ReplyInfoController {
	
	@Autowired
	private ReplyInfoService replyInfoService; 
	
	@RequestMapping("/getReplyList/{postId}")
	@ResponseBody
	public List<ReplyInfoVO> getReplyList(@PathVariable("postId") String postId) {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setPostId(Integer.parseInt(postId));
		
		return replyInfoService.selectReplyInfo(vo);
	}
}
