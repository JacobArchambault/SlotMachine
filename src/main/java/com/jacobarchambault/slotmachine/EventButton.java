package com.jacobarchambault.slotmachine;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EventButton extends Button {
	EventButton(final String text, final EventHandler<ActionEvent> event) {
		super(text);
		setOnAction(event);
	}

}
