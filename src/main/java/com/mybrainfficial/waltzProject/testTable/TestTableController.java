package com.mybrainfficial.waltzProject.testTable;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

@Controller
public class TestTableController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TestTableService testTableService;

	@RequestMapping(value = "/testTable.view", method = { RequestMethod.GET, RequestMethod.POST })
	public String view() {
		return "/testtable/testTable";
	}

	@RequestMapping(value = "/getTestTableList.json", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<TestTableVO> getTestTableList(TestTableVO vo) {
		return testTableService.getTestTableList(vo);
	}

	@RequestMapping(value = "/insertTestTable", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonObject insertTestTable(TestTableVO vo) {
		try {
			testTableService.insertTestTable(vo);
			return this.getSuccessCode();
		} catch (Throwable e) {
			logger.warn(ExceptionUtils.getStackTrace(e));
			return this.getFailCode(ExceptionUtils.getMessage(e));
		}
	}

	@RequestMapping(value = "/updateTestTable.json", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonObject updateTestTable(TestTableVO vo) {
		try {
			testTableService.updateTestTable(vo);
			return this.getSuccessCode();
		} catch (Throwable e) {
			logger.warn(ExceptionUtils.getStackTrace(e));
			return this.getFailCode(ExceptionUtils.getMessage(e));
		}
	}

	@RequestMapping(value = "/deleteTestTable.json", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public JsonObject deleteTestTable(TestTableVO vo) {
		try {
			testTableService.deleteTestTable(vo);
			return this.getSuccessCode();
		} catch (Throwable e) {
			logger.warn(ExceptionUtils.getStackTrace(e));
			return this.getFailCode(ExceptionUtils.getMessage(e));
		}
	}

	private JsonObject getSuccessCode() {
		JsonObject result = new JsonObject();
		result.addProperty("code", 1);
		result.addProperty("msg", "success");
		return result;
	}

	private JsonObject getFailCode(String msg) {
		JsonObject result = new JsonObject();
		result.addProperty("code", -1);
		result.addProperty("msg", msg);
		return result;
	}
}