package com.jacobarchambault.slotmachine;

import javafx.scene.control.TextField;

public class NumberInput extends TextField {
	
	double determineWinnings(final double amountBet, final int matches) {
		return amountBet * matches;
	}

}
