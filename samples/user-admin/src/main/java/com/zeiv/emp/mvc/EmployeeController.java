package com.zeiv.emp.mvc;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.samples.useradmin.util.ExtJSReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeiv.emp.repo.EmployeesAllAttrViewHome;

@Controller("employeeController")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Resource(name="employeesAllAttrViewHome")
	private EmployeesAllAttrViewHome employeesAllAttrViewHome;

	@RequestMapping(value = "/api/employee/employees.json", params = { "apikey", "start", "limit" }, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody
	Map<String, ? extends Object> getAllEmployees(@RequestParam("apikey") String apikey, @RequestParam("start") int start, @RequestParam("limit") int limit) {
		long startTime = System.currentTimeMillis();
//		logger.info("[로깅정보:getAllEmployees] apikey:{}, start:{}, limit:{}", apikey, start, limit);
		try {
			return ExtJSReturn.mapOK(employeesAllAttrViewHome.findAll(start, limit), employeesAllAttrViewHome.getTotalCountOfEmployeesAllAttrView(), startTime);
		} catch (Exception e) {
			e.printStackTrace();
			return ExtJSReturn.mapError(e.getLocalizedMessage());
		}
	}
}
