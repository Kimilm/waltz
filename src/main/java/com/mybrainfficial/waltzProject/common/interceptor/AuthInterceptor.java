package com.mybrainfficial.waltzProject.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter{
   private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
   
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
           throws Exception {

       HttpSession httpSession = request.getSession();

       if(httpSession.getAttribute("login") == null){           // 로그인 세션이 없을 때
            logger.info("현재 로그인한 사용자 없음");
            response.sendRedirect("/user/login");
            return false;
       }

       return true;
   }
}


