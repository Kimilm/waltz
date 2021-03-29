package com.mybrainfficial.waltzProject.userInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;
import com.mybrainfficial.waltzProject.ResultVO;
import com.mybrainfficial.waltzProject.common.commonUtil.MessageUtil;

@Controller
public class UserInfoController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserInfoService UserInfoService;

	// 로그인 초기화면
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String selectLoginForm() throws Exception {
		return "/user/login";
	}

	// 로그인
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public void getUserInfo(UserInfoVO vo, HttpServletRequest request, HttpServletResponse response, Model model) {

		String resultMsg = "";
		String resultCode = "";
		String lockFlag = "";
		String failCntFlag = "";
		int userFailCnt = 0;

		try{
			UserInfoVO userInfo = UserInfoService.selectUserInfo(vo);

			// 로그인 계정 체크
		/*
			CASE 1. (9999) 사용자 정보가 없는 경우
			CASE 2. (9998) 사용자 패스워드가 틀린 경우
			CASE 3. (9997) 패스워드 초기화 일자가 60일이상 지난 경우 > ALERT ALAM 발생 후, LOGIN 성공
			CASE 4. (9996) 패스워드 초기화 일자가 90일이상 지난 경우 > ALERT ALAM 발생 후, 패스워드 변경 화면 이동
			CASE 5. (9995) 패스워드 실패 횟수가 5회 이상인 경우 > ALERT ALAM 발생 후, 계정 잠김
			CASE 6. (0000) 로그인 정상 성공 (패스워드 실패 횟수 초기화)
		 */

			if(userInfo == null){
				resultCode = "9999";
				resultMsg = "사용자 정보가 없습니다";
			}else{
				// 현재 시각 timestamp
//				LocalDateTime currentDateTime = LocalDateTime.now();
//				Timestamp timestamp = Timestamp.valueOf(currentDateTime);
//
//				long nowTimeStamp = timestamp.getTime();
//
//				// db initday timestamp
//				Timestamp timestamp2 = Timestamp.valueOf(userInfo.getUserInitDate().toString());
//				long dbInitTimeStamp = timestamp2.getTime();
//
//				Calendar cal = Calendar.getInstance();
//
//				// DB 저장된 초기화 일자보다 60일 이후 timestamp
//				cal.setTimeInMillis(dbInitTimeStamp);
//				cal.add(Calendar.DAY_OF_MONTH, 60);
//				long sixtyDaysAfterDbInitTimestamp = cal.getTime().getTime();
//
//				// DB 저장된 초기화 일자보다 90일 이후 timestamp
//				cal.add(Calendar.DAY_OF_MONTH, 30);
//				long nintyDaysAfterDbInitTimestamp = cal.getTime().getTime();

//				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//				int initDate1 =  Integer.parseInt(formatter.format(nowTimeStamp));

				userFailCnt = userInfo.getUserPwdErrNumbs();

//				if(!BCrypt.checkpw(vo.getUserPwd(), userInfo.getUserPwd())) {
//					// 패스워드 실패 시, 현재 DB에 저장된 fail count가 5라면 잠김
//					if(userFailCnt >= 30){
//						resultCode = "9995";
//						resultMsg = "사용자 패스워드 실패 횟수 초과입니다. 계정이 잠깁니다.";
//						lockFlag = "Y";
//						failCntFlag = "Y";
//					}else{
//						resultCode = "9998";
//						resultMsg = "사용자 계정정보가 올바르지 않습니다.";
//						failCntFlag = "Y";
//					}
//
//				}
//				else if(nowTimeStamp > sixtyDaysAfterDbInitTimestamp){
//					if(nowTimeStamp < nintyDaysAfterDbInitTimestamp){
//						resultCode = "9997";
//						resultMsg = "패스워드 초기화 일자가 60일이 지났습니다. 패스워드를 변경 해 주세요.";
//					}else{
//						resultCode = "9996";
//						resultMsg = "패스워드 초기화 일자가 90일이 지났습니다. 계정이 잠깁니다.";
//						lockFlag = "Y";
//					}
//				}
//				else{
					resultCode = "0000";
//				}
			}

			// Action
			if("0000".equals(resultCode) || "9997".equals(resultCode)){
				// 정상 또는 패스워드 초기일자 알람 PASS
				request.setAttribute("user", userInfo);
				request.setAttribute("userId", userInfo.getUserId());
				request.setAttribute("userNm", userInfo.getUserNm());
			}else{
				// 계정 잠김 처리
				if("Y".equals(lockFlag)){
					vo.setUserPwd("");
					vo.setUserIdLckYn("Y");
					UserInfoService.updateUserInfo(vo);
				}

				// 실패횟수 증가 처리
				if("Y".equals(failCntFlag)){
					++userFailCnt;
					vo.setUserPwd("");
					vo.setUserPwdErrNumbs(userFailCnt);
					UserInfoService.updateUserInfo(vo);
				}

				// 메시지 출력
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('" + resultMsg + "'); location.href='/user/login';</script>");
				out.flush();
			}
		}catch(Exception e){
			e.getStackTrace();
		}
	}


	// 로그아웃
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();

		return "/user/login";
	}


	// 회원등록 초기화면
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String insertUserInfoForm() throws Exception {
		return "/user/register";
	}

	// 회원등록
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
	public ResultVO insertUserInfo(UserInfoVO vo, RedirectAttributes redirectAttributes) {

		String hashedPw = BCrypt.hashpw(vo.getUserPwd(), BCrypt.gensalt());						// pw hash 암호화
		vo.setUserPwd(hashedPw);																	// hashed password 세팅
		int result = UserInfoService.insertUserInfo(vo);

		return MessageUtil.getMessage(result);
	}

	// 회원정보 상세 초기화면
	@RequestMapping(value = "/user/info", method = RequestMethod.GET)
	public String updateUserInfo(HttpSession session, Model model, UserInfoVO vo) throws Exception{

        model.addAttribute("login", session.getAttribute("login"));

		return "/user/info";
	}

	// 회원정보 수정
	@RequestMapping(value = "/user/info/modify", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVO updateUserInfo(HttpSession session, Model model, UserInfoVO vo, ResultVO rvo) {

		vo.setUserId(session.getAttribute("userId").toString());
		String hashedPw = BCrypt.hashpw(vo.getUserPwd(), BCrypt.gensalt());						// pw hash 암호화
		vo.setUserPwd(hashedPw);																	// hashed password 세팅

		int result = UserInfoService.updateUserInfo(vo);

		return MessageUtil.getMessage(result);
	}
}
