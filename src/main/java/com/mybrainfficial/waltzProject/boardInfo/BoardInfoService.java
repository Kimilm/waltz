package com.mybrainfficial.waltzProject.boardInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardInfoService {
	
	@Autowired
	private BoardInfoDAO boardInfoDao;
	
	public List<BoardInfoVO> selectListBoardInfo(BoardInfoVO vo) {
		return boardInfoDao.selectListBoardInfo(vo);
	}
	
	public List<PostVO> selectListPost(BoardInfoVO vo) {
		return boardInfoDao.selectListPost(vo);
	}
}
