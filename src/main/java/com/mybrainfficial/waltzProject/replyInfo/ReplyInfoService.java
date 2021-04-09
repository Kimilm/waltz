package com.mybrainfficial.waltzProject.replyInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mybrainfficial.waltzProject.boardInfo.BoardInfoVO;

@Service
public class ReplyInfoService {
	@Autowired
	private ReplyInfoDAO replyInfoDao;
	
	public List<ReplyInfoVO> selectReplyInfo(final BoardInfoVO vo) throws DataAccessException {
		return replyInfoDao.selectReplyInfo(vo);
	}
}
