package com.jacobarchambault.slotmachine;

import javafx.scene.control.TextField;

class NumberInput extends TextField {

	NumberInput() {
		textProperty().addListener((final var observable, final var oldValue, final var newValue) -> {
			if (!newValue.matches("\\d*")) {
				setText(newValue.replaceAll("[^\\d]", ""));
			}
		});
	}

	double determineWinnings(final int matches) throws NumberFormatException {
		return Double.parseDouble(getText()) * matches;
	}

}
