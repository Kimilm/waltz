package com.mybrainfficial.waltzProject.boardInfo;

import java.io.Serializable;

import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

public class PostVO implements Serializable {
	private BoardInfoVO boardInfoVo;
	private UserInfoVO userInfoVo;
	
	public BoardInfoVO getBoardInfoVo() {
		return boardInfoVo;
	}
	public void setBoardInfoVo(BoardInfoVO boardInfoVo) {
		this.boardInfoVo = boardInfoVo;
	}
	public UserInfoVO getUserInfoVo() {
		return userInfoVo;
	}
	public void setUserInfoVo(UserInfoVO userInfoVo) {
		this.userInfoVo = userInfoVo;
	}
	
}
