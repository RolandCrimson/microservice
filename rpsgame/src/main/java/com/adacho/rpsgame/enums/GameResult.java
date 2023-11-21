package com.adacho.rpsgame.enums;

public enum GameResult {
	WON("승"), LOST("패"), SAME("비김");
	
	private String commentary;
	
	private GameResult(String content) {
		this.commentary = content;
	}

	public String getCommentary() {
		return commentary;
	}
}
