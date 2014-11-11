package org.cdac.controllers;

import org.cdac.models.User;
import org.cdac.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String view() {
		return "login";
	}

	@RequestMapping(value = "/account")
	public String authorize(@CurrentUser final User user) {
		if (user == null)
			return "login";
		else if (user.getRole().contains("ROLE_ADMIN"))
			return "admin";
		else if (user.getRole().contains("ROLE_USER"))
			return "user";
		else if (user.getRole().contains("ROLE_AUDITER"))
			return "auditor";
		else
			return "error";
	}
}
