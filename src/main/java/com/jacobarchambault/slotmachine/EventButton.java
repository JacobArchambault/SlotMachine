package com.jacobarchambault.slotmachine;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

class EventButton extends Button {

	Slots slots;
	NumberInput betField;
	DisplayLabel displayInfoLabel;
	UI ui;

	EventButton(final String text, final EventHandler<ActionEvent> event) {
		super(text);
		setOnAction(event);
	}

	public EventButton(
			String string,
			Slots slots,
			NumberInput insertedTextField,
			DisplayLabel displayInfoLabel,
			UI ui) {
		super(string);
		this.slots = slots;
		this.betField = insertedTextField;
		this.displayInfoLabel = displayInfoLabel;
		this.ui = ui;
		setOnAction(e -> play());
	}

	private void play() {
		try {
			int[] ints = slots.spin();
			final var fromMatches = Slots.numberOfMatches(ints);
			final var amountWon = betField.determineWinnings(fromMatches);
			displayInfoLabel.displayMatchText(fromMatches);
			updateUI(ints, amountWon);
		} catch (final NumberFormatException ex) {
			displayInfoLabel.setText("Insert an amount to play.");
		}
	}

	private void updateUI(int[] ints, final double amountWon) {
		slots.updateUI(ints);
		ui.update(amountWon);
	}
}