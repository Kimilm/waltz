package com.mybrainfficial.waltzProject.replyInfo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybrainfficial.waltzProject.ResultVO;
import com.mybrainfficial.waltzProject.boardInfo.BoardInfoVO;
import com.mybrainfficial.waltzProject.common.commonUtil.MessageUtil;
import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Controller
public class ReplyInfoController {
	
	@Autowired
	private ReplyInfoService replyInfoService; 
	
	/* create */
	@RequestMapping(value="/createReply", method=RequestMethod.POST)
	@ResponseBody
	public ResultVO createReply(HttpSession session, ReplyInfoVO vo) {
		if (vo.getReplyConts() == null)
			return MessageUtil.getFailCode();

		UserInfoVO user = (UserInfoVO) session.getAttribute("login");
		vo.setReplyWrtrId(user.getUserId());
		vo.setCrtId(user.getUserId());
		
		int result = replyInfoService.insertReplyInfo(vo);
		return MessageUtil.getMessage(result);
	}
	/* create */
	
	/* read */
	@RequestMapping("/getReplyList/{postId}")
	@ResponseBody
	public List<ReplyInfoVO> getReplyList(@PathVariable("postId") String postId) {
		BoardInfoVO vo = new BoardInfoVO();
		vo.setPostId(Integer.parseInt(postId));
		
		return replyInfoService.selectReplyInfo(vo);
	}
	/* read */
	
	/* update */	
	@RequestMapping(value="/updateReply", method=RequestMethod.POST)
	@ResponseBody
	public ResultVO updateReply(HttpSession session, ReplyInfoVO vo) {
		if (vo.getReplyConts() == null)
			return MessageUtil.getFailCode();

		UserInfoVO user = (UserInfoVO) session.getAttribute("login");
		vo.setUpdtId(user.getUserId());
		
		int result = replyInfoService.updateReplyInfo(vo);
		return MessageUtil.getMessage(result);
	}
	/* update */
	
	/* logical delete */
	@RequestMapping(value="/deleteReply", method=RequestMethod.POST)
	@ResponseBody
	public ResultVO deleteReply(ReplyInfoVO vo) {
		replyInfoService.deleteReplyInfo(vo);
		return MessageUtil.getSuccessCode();
	}
	/* delete */
}
