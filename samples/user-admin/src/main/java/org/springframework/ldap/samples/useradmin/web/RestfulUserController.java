package org.springframework.ldap.samples.useradmin.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.samples.useradmin.domain.DepartmentRepo;
import org.springframework.ldap.samples.useradmin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/user")
public class RestfulUserController {
	private static final Logger logger = LoggerFactory.getLogger(RestfulUserController.class);
	
    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentRepo departmentRepo;

	@RequestMapping(value = "users.json", params = { "apikey" }, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody
	Map<String, ? extends Object> list(@RequestParam("apikey") String apikey) {
		long startTime = System.currentTimeMillis();
		logger.info("로깅합니다: Map getAllCustomers()");
		try {
			return ExtJSReturn.mapOK(customersHome.findAllCustomers(), startTime);
		} catch (Exception e) { 
			e.printStackTrace();
			return ExtJSReturn.mapError(e.getLocalizedMessage());
		}
	}
}
