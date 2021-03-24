package com.jacobarchambault.slotmachine;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class CenteredHBox extends HBox {

	CenteredHBox(double spacing, Node... children){
		super(spacing, children);
		setAlignment(Pos.CENTER);
	}
}
