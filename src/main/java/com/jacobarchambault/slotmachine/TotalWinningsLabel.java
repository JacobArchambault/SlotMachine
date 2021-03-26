package com.jacobarchambault.slotmachine;

import javafx.scene.control.Label;

public class TotalWinningsLabel extends Label{

	double totalWinnings;
	TotalWinningsLabel(String text, double startAmount){
		super(text);
		this.totalWinnings = startAmount;
	}
	TotalWinningsLabel(String text){
		this(text, 0);
	}
}
