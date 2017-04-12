package org.raescott.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Richard Scott Smith <scott.smith@isostech.com>
 */
@Controller
@RequestMapping(value = "/")
public class MainController {
	@RequestMapping(method = RequestMethod.GET)
	String index() {
		return "index";
	}
}
