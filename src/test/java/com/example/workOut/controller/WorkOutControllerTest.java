package com.example.workOut.controller;

import com.example.workOut.domain.DayOfCalendar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class WorkOutControllerTest {

    @Test
    @DisplayName("리스트 확인")
    void listCheck(){

        DayOfCalendar dc = new DayOfCalendar();

        List<Integer> list = dc.prn(2023, 2);
        System.out.println("list = " + list);
    }
}