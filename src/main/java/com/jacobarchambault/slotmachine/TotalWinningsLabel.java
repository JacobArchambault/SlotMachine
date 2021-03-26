package com.jacobarchambault.slotmachine;

import javafx.scene.control.Label;

public class TotalWinningsLabel extends Label {

	double totalWinnings;

	TotalWinningsLabel(final String text) {
		this(text, 0);
	}

	TotalWinningsLabel(final String text, final double startAmount) {
		super(text);
		totalWinnings = startAmount;
	}

	double update(final double amountWon) {
		totalWinnings += amountWon;
		return totalWinnings;
	}
}
