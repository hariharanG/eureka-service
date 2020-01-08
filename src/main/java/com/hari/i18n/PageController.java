package com.hari.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/international")
	public String getI18nPage() {
		return "international";
	}
	
	
}
