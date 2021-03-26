package com.jacobarchambault.slotmachine;

import javafx.scene.control.Label;

class DisplayLabel extends Label {

	DisplayLabel(final String text) {
		super(text);
	}

	int displayText(final int forMatchNumber) {
		setText(
				forMatchNumber == 3 ? "Jackpot! TRIPLE WIN x 3!!"
						: forMatchNumber == 2 ? "Sweet! DOUBLE WIN x 2!!" : "No Luck. Play again!");
		return forMatchNumber;
	}

}
