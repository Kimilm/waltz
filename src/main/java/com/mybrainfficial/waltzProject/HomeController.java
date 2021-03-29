package com.mybrainfficial.waltzProject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	// normal
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// static
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "/user/login";
	}

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public String home(Locale locale, HttpSession session, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.debug("debug test");
		logger.error("error test");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("login", session.getAttribute("login"));

        return "/index";
	}


	@RequestMapping(value = "/getList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<String> getData() {
		List<String> result = new ArrayList<>();
		result.add("first");
		result.add("second");
		result.add("third");
		return result;
	}

	@RequestMapping(value = "/getMap", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, String> getMap() {
		Map<String, String> result = new HashMap<>();

		result.put("first", "firstValue");
		result.put("second", "secondValue");
		result.put("third", "thirdValue");
		return result;
	}

	@RequestMapping(value = "/getString", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String getString() {
		return "stringValue";
	}
}
