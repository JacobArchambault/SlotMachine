package com.jacobarchambault.slotmachine;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

class EventButton extends Button {

	Slots slots;
	NumberInput betField;
	DisplayLabel displayInfoLabel;
	Label wonThisSpinOutputLabel;
	TotalWinningsLabel totalWonOutputLabel;

	EventButton(final String text, final EventHandler<ActionEvent> event) {
		super(text);
		setOnAction(event);
	}

	public EventButton(
			String string,
			Slots slots,
			NumberInput insertedTextField,
			DisplayLabel displayInfoLabel,
			Label wonThisSpinOutputLabel,
			TotalWinningsLabel totalWonOutputLabel) {
		super(string);
		this.slots = slots;
		this.betField = insertedTextField;
		this.displayInfoLabel = displayInfoLabel;
		this.wonThisSpinOutputLabel = wonThisSpinOutputLabel;
		this.totalWonOutputLabel = totalWonOutputLabel;
		setOnAction(e -> {
			extracted();
		});
	}

	private void extracted() {
		try {
			int[] ints = slots.spin();
			final var fromMatches = Spin.numberOfMatches(ints);
			final var amountWon = betField.determineWinnings(fromMatches);
			update(ints, fromMatches, amountWon);
		} catch (final NumberFormatException ex) {
			displayInfoLabel.setText("Insert an amount to play.");
		}
	}

	private void update(int[] ints, final int fromMatches, final double amountWon) {
		slots.change(ints);
		displayInfoLabel.displayMatchText(fromMatches);
		wonThisSpinOutputLabel.setText(String.format("$%,.2f", amountWon));
		totalWonOutputLabel.displayUpdate(amountWon);
	}
}