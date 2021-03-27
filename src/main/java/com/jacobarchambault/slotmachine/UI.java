package com.jacobarchambault.slotmachine;

import javafx.scene.control.Label;

class UI {

	Slots slots;
	DisplayLabel displayInfoLabel;
	Label wonThisSpinOutputLabel;
	TotalWinningsLabel totalWonOutputLabel;
	UI(
			Slots slots,
			DisplayLabel displayInfoLabel,
			Label wonThisSpinOutputLabel,
			TotalWinningsLabel totalWonOutputLabel) {
		this.slots = slots;
		this.displayInfoLabel = displayInfoLabel;
		this.wonThisSpinOutputLabel = wonThisSpinOutputLabel;
		this.totalWonOutputLabel = totalWonOutputLabel;
	}
	void update(int[] ints, final int fromMatches, final double amountWon) {
		slots.change(ints);
		displayInfoLabel.displayMatchText(fromMatches);
		wonThisSpinOutputLabel.setText(String.format("$%,.2f", amountWon));
		totalWonOutputLabel.displayUpdate(amountWon);
	}

}
