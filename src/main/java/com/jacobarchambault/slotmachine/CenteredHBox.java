package com.jacobarchambault.slotmachine;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

class CenteredHBox extends HBox {

	CenteredHBox(final double spacing, final Node... children) {
		super(spacing, children);
		setAlignment(Pos.CENTER);
	}

	CenteredHBox(final Node... children) {
		this(10, children);
	}
}
