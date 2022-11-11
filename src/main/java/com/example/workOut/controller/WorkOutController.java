package com.example.workOut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkOutController {

	@GetMapping("workout")
	public String workOut() {
		return "workout";
	}
}
