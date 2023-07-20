package com.example.workOut.domain;

import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//달력 만들기 
//요일계산 -> year년 month월을 주면, year년 month월 1일의 요일 -> 요일만큼 공백 -> 7개씩 새로운 줄 

public class DayOfCalendar {

  //윤년 계산
  private static boolean isLeapYear(int year) {

    return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
  } 

  // 해당 월의 마지막 날짜 계산
  private static int getDate(int year, int month) {
    List<Integer> lastDay = null;

    // 윤년일 때
    if(isLeapYear(year)) {
      lastDay = new ArrayList<Integer>(Arrays.asList(31,29,31,30,31,30,31,31,30,31,30,31));
    // 윤년이 아닐 때
    }else {
      lastDay = new ArrayList<Integer>(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31));
    }

    return lastDay.get(month-1);
  }

  //해당 월의 첫번쨰 요일 계산 
  private static int getDayOfWeek(int year, int month) { 
    int dayOfWeek = 0; 
    int sum = 0; 

    // 1.1.1 ~ year-1.12.31 
    for(int i = 1; i < year; i++) { 
      for(int j = 1; j <= 12; j++) { 
        sum += getDate(i, j); 
      } 
    } 

    //year.1.1 ~ year.month-1.마지막(31,30.29.28) 
    for(int k = 1; k < month; k++) { 
      sum += getDate(year, k); 
    } 

    //year.month.1일 
    sum += 1; 

    //요일 
    dayOfWeek = sum % 7;

    return dayOfWeek; 
  } 

  // 년, 월을 입력하면 해당 월의 날짜를 리스트에 담아 반환한다.
  public List<Integer> prn(int year, int month) {

    List<Integer> list = new ArrayList<Integer>();
    
    //시작 요일 
    int start = DayOfCalendar.getDayOfWeek(year, month); 

    //마지막 날짜 
    int last = getDate(year, month); 

    //시작 요일만큼 빈공간 
    for(int i = 1; i <= start; i++) { 
      list.add(0);
    }

    //달력출력 
    for(int i = 1; i <= last; i++) { 
    	list.add(i);
    	start++; 
    }
    
	return list; 
  } 
}