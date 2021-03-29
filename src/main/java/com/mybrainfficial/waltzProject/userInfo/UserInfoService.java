package com.mybrainfficial.waltzProject.userInfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
	@Resource
	private UserInfoDAO UserInfoDAO;

	public UserInfoVO selectUserInfo(final UserInfoVO vo) throws DataAccessException {
		return UserInfoDAO.selectUserInfo(vo);
	}

	public int insertUserInfo(final UserInfoVO vo) throws DataAccessException {
		return UserInfoDAO.insertUserInfo(vo);
	}

	public int updateUserInfo(final UserInfoVO vo) throws DataAccessException {
		return UserInfoDAO.updateUserInfo(vo);
	}

	public int deleteUserInfo(final UserInfoVO vo) throws DataAccessException {
		return UserInfoDAO.deleteUserInfo(vo);
	}
}
