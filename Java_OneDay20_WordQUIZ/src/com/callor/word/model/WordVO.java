package com.callor.word.model;

public class WordVO {
	
	String english;
	String korea;
	
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKorea() {
		return korea;
	}
	public void setKorea(String korea) {
		this.korea = korea;
	}
	@Override
	public String toString() {
		return "WordVO [영어 = " + english + ", 한글 = " + korea + "]";
	}
	
	
	

}
