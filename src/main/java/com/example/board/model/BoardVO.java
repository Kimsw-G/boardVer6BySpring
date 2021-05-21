package com.example.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	private int iboard;
	private String title;
	private String ctnt;
	private int iuser;
	private String regdt;
	
	private String unm;
	private int isFav;
	private String search;
}
