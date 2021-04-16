package com.callor.word.service;

import com.callor.word.model.WordVO;

public interface QuizService {
	
	public void selectMenu();
	public void readFile();
	public void loadFile();
	public void saveFile(Integer playerPoint);
	public void viewFile();
	public WordVO getWord();
	public WordVO quiz();
	public void help();
	

}
