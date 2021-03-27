package com.jacobarchambault.slotmachine;

import javafx.scene.control.Label;

class UI {

	DisplayLabel displayInfoLabel;
	Label wonThisSpinOutputLabel;
	TotalWinningsLabel totalWonOutputLabel;

	UI(DisplayLabel displayInfoLabel, Label wonThisSpinOutputLabel, TotalWinningsLabel totalWonOutputLabel) {
		this.displayInfoLabel = displayInfoLabel;
		this.wonThisSpinOutputLabel = wonThisSpinOutputLabel;
		this.totalWonOutputLabel = totalWonOutputLabel;
	}

	void update(final int fromMatches, final double amountWon) {
		displayInfoLabel.displayMatchText(fromMatches);
		wonThisSpinOutputLabel.setText(String.format("$%,.2f", amountWon));
		totalWonOutputLabel.displayUpdate(amountWon);
	}

}
