package com.example.workOut.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.workOut.domain.DayOfCalendar;

@Controller
@RequestMapping("/workout")
public class WorkOutController {

	/**
	 * 운동일정 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String workOut(Model model) {

		DayOfCalendar dayCalendar = new DayOfCalendar();

		// 현재 날짜 가져오기
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonthValue();

		Map<String, Object> nowDate = new HashMap<>();
		nowDate.put("year", year);
		nowDate.put("month", month);

		List<Integer> list = dayCalendar.getMonthDays(year, month);

		model.addAttribute("dayCalendar", list);
		model.addAttribute("nowDate", nowDate);

		return "workout";
	}
	// 팝업 요청 시
	@GetMapping("/input")
	public String workoutPopUp(@RequestParam("date") String date,
							   Model model) {

//		Map<String, Object> date = new HashMap<>();
//		date.put("date", date);
		// Gson 객체 생성
//		Gson gson = new Gson();
//		String jsonDate = gson.toJson(date);
//
//		System.out.println("jsonDate = " + jsonDate);
		// 받아온 날짜 데이터들을 date map 에 넣어서 팝업 화면에 응답으로 보냄
		model.addAttribute("date",date);
		return "workoutPopup";
	}

	@PostMapping ("/save-exercise")
	public ResponseEntity<Object> saveWorkout(@RequestBody Map<String,Object> param) {

		System.out.println("param: "+param);

		// exercise 에 값이 존재한다면
		if(param.get("exercise") != null){
			// header 생성
//			HttpHeaders headers= new HttpHeaders();
//			headers.add("Custom-Header", "foo");

			return ResponseEntity
					.ok()
//					.headers(headers)
					.body(param);
		}else{
			return ResponseEntity.badRequest().body("error 이다.");
		}
	}
}
