package com.jacobarchambault.slotmachine;

import javafx.scene.control.Label;

class WinningsLabels {

	Label wonThisSpinOutputLabel;
	TotalWinningsLabel totalWonOutputLabel;

	WinningsLabels(Label wonThisSpinOutputLabel, TotalWinningsLabel totalWonOutputLabel) {
		this.wonThisSpinOutputLabel = wonThisSpinOutputLabel;
		this.totalWonOutputLabel = totalWonOutputLabel;
	}

	void update(final double amountWon) {
		wonThisSpinOutputLabel.setText(String.format("$%,.2f", amountWon));
		totalWonOutputLabel.displayUpdate(amountWon);
	}

}
