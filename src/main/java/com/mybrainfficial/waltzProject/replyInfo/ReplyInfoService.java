package com.mybrainfficial.waltzProject.replyInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mybrainfficial.waltzProject.boardInfo.BoardInfoVO;
import com.mybrainfficial.waltzProject.common.commonUtil.MessageUtil;
import com.mybrainfficial.waltzProject.userInfo.UserInfoVO;

@Service
public class ReplyInfoService {
	@Autowired
	private ReplyInfoDAO replyInfoDao;
	
	public List<ReplyInfoVO> selectReplyInfo(final BoardInfoVO vo) throws DataAccessException {
		return replyInfoDao.selectReplyInfo(vo);
	}
	
	public int insertReplyInfo(final ReplyInfoVO vo) throws DataAccessException {		
		return replyInfoDao.insertReplyInfo(vo);
	}
	
	public int updateReplyInfo(final ReplyInfoVO vo) throws DataAccessException {
		return replyInfoDao.updateReplyInfo(vo);
	}
	
	// logical delete
	public int deleteReplyInfo(final ReplyInfoVO vo) throws DataAccessException {
		return replyInfoDao.deleteReplyInfo(vo);
	}
}
