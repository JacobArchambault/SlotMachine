package com.jacobarchambault.slotmachine;

import javafx.scene.control.Label;

public class DisplayLabel extends Label {

	DisplayLabel(String text) {
		super(text);
	}

	int displayText(int forMatchNumber) {
		setText(
				forMatchNumber == 3 ? "Jackpot! TRIPLE WIN x 3!!"
						: forMatchNumber == 2 ? "Sweet! DOUBLE WIN x 2!!" : "No Luck. Play again!");
		return forMatchNumber;
	}

}
