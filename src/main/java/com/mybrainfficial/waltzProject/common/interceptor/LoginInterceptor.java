package com.mybrainfficial.waltzProject.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{


   private static final String Login = "login";
   private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	   Object userVo = request.getAttribute("user");
	   
       HttpSession httpSession = request.getSession();
       if(userVo != null){
           logger.info("new login session");
           httpSession.setAttribute(Login, userVo);
           httpSession.setAttribute("userId", request.getAttribute("userId"));
           httpSession.setAttribute("userNm", request.getAttribute("userNm"));

           response.sendRedirect("/setMenu");
       }

   }

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
           throws Exception {

       HttpSession httpSession = request.getSession();
       if (httpSession.getAttribute(Login) != null) {
           logger.info("clear login data before");
           httpSession.removeAttribute(Login);
           
           httpSession.removeAttribute("menuMt");
           httpSession.removeAttribute("menuDt");
       }

       return true;
   }
}


