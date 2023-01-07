package com.example.workOut.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.workOut.domain.DayOfCalendar;

@Controller
public class WorkOutController {

	@GetMapping("workout")
	public String workOut(Model model) {
		
		List<Integer> list = DayOfCalendar.prn(2023, 1);
		
		model.addAttribute("list",list);
		
		return "workout";
	}
}
