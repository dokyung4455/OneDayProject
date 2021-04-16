package com.callor.word;

import com.callor.word.impl.QuizServiceImplV1;
import com.callor.word.service.QuizService;

public class QuizEx_01 {
	
	public static void main(String[] args) {
		
		QuizService qService = new QuizServiceImplV1();
		
		qService.selectMenu();
	}

}
