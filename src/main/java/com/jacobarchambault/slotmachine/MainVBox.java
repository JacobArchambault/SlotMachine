package com.jacobarchambault.slotmachine;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

class MainVBox extends VBox {
	MainVBox(final double spacing, final Node... children) {
		super(spacing, children);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(10));
	}

	MainVBox(final Node... children) {
		this(10, children);
	}

}
