package com.jacobarchambault.slotmachine;

import javafx.scene.control.TextField;

class NumberInput extends TextField {

	NumberInput() {
	}

	double determineWinnings(final int matches) {
		return Double.parseDouble(getText()) * matches;
	}

}
