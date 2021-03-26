package com.jacobarchambault.slotmachine;

import javafx.scene.control.TextField;

public class NumberInput extends TextField {

	double determineWinnings(final int matches) {
		return Double.parseDouble(getText()) * matches;
	}

}
