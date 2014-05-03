/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ldap.samples.useradmin.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.samples.useradmin.domain.DepartmentRepo;
import org.springframework.ldap.samples.useradmin.domain.User;
import org.springframework.ldap.samples.useradmin.service.UserService;
import org.springframework.ldap.samples.useradmin.util.ExtJSReturn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

/**
 * @author Mattias Hellborg Arthursson
 */
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final AtomicInteger nextEmployeeNumber = new AtomicInteger(10);

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentRepo departmentRepo;

    @RequestMapping(value = {"/", "/users"}, method = GET)
    public String index(ModelMap map, @RequestParam(required = false) String name) {
        if(StringUtils.hasText(name)) {
            map.put("users", userService.searchByNameName(name));
        } else {
            map.put("users", userService.findAll());
        }
        return "listUsers";
    }

	@RequestMapping(value = "/api/user/users.json", params = { "apikey" }, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody
	Map<String, ? extends Object> userList(@RequestParam("apikey") String apikey) {
		long startTime = System.currentTimeMillis();
		logger.info("로깅합니다: userList1");
		try {
			List<User> user_list = Lists.newArrayList(userService.findAll());
			logger.info("name: {}", user_list.get(3).getFullName());
			return ExtJSReturn.mapOK(user_list, startTime);
		} catch (Exception e) { 
			logger.info("로깅합니다: userList5");
			e.printStackTrace();
			return ExtJSReturn.mapError(e.getLocalizedMessage());
		}
	}
    
    @RequestMapping(value = "/users/{userid}", method = GET)
    public String getUser(@PathVariable String userid, ModelMap map) throws JsonProcessingException {
        map.put("user", userService.findUser(userid));
        populateDepartments(map);
        return "editUser";
    }

    @RequestMapping(value = "/newuser", method = GET)
    public String initNewUser(ModelMap map) throws JsonProcessingException {
        User user = new User();
        user.setEmployeeNumber(nextEmployeeNumber.getAndIncrement());

        map.put("new", true);
        map.put("user", user);
        populateDepartments(map);

        return "editUser";
    }

    private void populateDepartments(ModelMap map) throws JsonProcessingException {
        Map<String, List<String>> departmentMap = departmentRepo.getDepartmentMap();
        ObjectMapper objectMapper = new ObjectMapper();
        String departmentsAsJson = objectMapper.writeValueAsString(departmentMap);
        map.put("departments", departmentsAsJson);
    }

    @RequestMapping(value = "/newuser", method = POST)
    public String createUser(User user) {
        User savedUser = userService.createUser(user);

        return "redirect:/users/" + savedUser.getId();
    }

    @RequestMapping(value = "/users/{userid}", method = POST)
    public String updateUser(@PathVariable String userid, User user) {
        User savedUser = userService.updateUser(userid, user);

        return "redirect:/users/" + savedUser.getId();
    }
}
