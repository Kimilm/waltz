package com.mybrainfficial.waltzProject.common.context.aop.logging;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

@Aspect
public class TraceLoggingInAOP {
	private static final Gson GSON = new Gson();
	private static final Logger LOGGER = LoggerFactory.getLogger(TraceLoggingInAOP.class);
	private static final String STR_CLASS_METHOD = "{0}.{1}({2})";
	private static final String STR_START_EXECUTE_TIME = "{} START ....... Execute Time ....... : {}";
	private static final String STR_END_EXECUTE_TIME = "{} E N D ....... Execute Time ....... : {} - return Value({}) : {}";

	@Around("execution(* com.mybrainfficial.waltzProject..*Controller.*(..)) || execution(* com.mybrainfficial.waltzProject..*Service.*(..)) || execution(* com.mybrainfficial.waltzProject..*DAO.*(..))")
	public Object doLoggingAround(final ProceedingJoinPoint pjp) throws Throwable {
		Object retVal = null;

		final String formatClassMethod = MessageFormat.format(STR_CLASS_METHOD, pjp.getTarget().getClass().getSimpleName(), pjp.getSignature().getName(), this.getAgumentNames(pjp.getArgs()));

		try {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			LOGGER.info(STR_START_EXECUTE_TIME, formatClassMethod, stopWatch.toString());

			retVal = pjp.proceed();

			stopWatch.stop();
			LOGGER.info(STR_END_EXECUTE_TIME, formatClassMethod, stopWatch.toString(), ((MethodSignature) pjp.getSignature()).getReturnType().getSimpleName(),
					StringUtils.defaultString(GSON.toJson(retVal), "null"));
		} catch (Throwable e) {
			LOGGER.warn("{} -\n{}", formatClassMethod, ExceptionUtils.getStackTrace(e));
			throw e;
		}
		return retVal;
	}

	private String getAgumentNames(final Object[] obj) {
		final List<String> list = new ArrayList<String>();
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				list.add(obj[i].getClass().getSimpleName());
			}
		}
		return StringUtils.join(list, ", ");
	}
}