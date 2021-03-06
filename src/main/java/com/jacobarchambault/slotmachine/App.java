package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
	public static void main(final String[] args) {
		Application.launch();
	}

	private final Image[] images = new Image[] { new Image("file:Apple.png"), new Image("file:Banana.png"),
			new Image("file:Cherries.png"), new Image("file:Grapes.png"), new Image("file:Lemon.png"),
			new Image("file:Lime.png"), new Image("file:Orange.png"), new Image("file:Pear.png"),
			new Image("file:Strawberry.png"), new Image("file:Watermelon.png") };
	private final ImageView[] slotImages = new ImageView[] { new ImageView(images[2]), new ImageView(images[2]),
			new ImageView(images[2]) };

	// Input
	NumberInput insertedTextField = new NumberInput();
	// Outputs
	Label wonThisSpinOutputLabel = new Label("$0.00");
	TotalWinningsLabel totalWonOutputLabel = new TotalWinningsLabel("$0.00");
	DisplayLabel displayInfoLabel = new DisplayLabel("Insert an amount to play.");

	@Override
	public void start(final Stage primaryStage) {
		primaryStage
				.setScene(
						new Scene(
								new MainVBox(
										new HBox(10, slotImages[0], slotImages[1], slotImages[2]),
										new CenteredHBox(new Label("Amount Inserted: "), insertedTextField),
										new CenteredHBox(new Label("Amount Won This Spin: "), wonThisSpinOutputLabel),
										new CenteredHBox(new Label("Total Amount Won: "), totalWonOutputLabel),
										new EventButton(
												"Spin",
												new Slots(new SlotImages(new Random(), slotImages), images),
												insertedTextField,
												displayInfoLabel,
												new WinningsLabels(wonThisSpinOutputLabel, totalWonOutputLabel)),
										displayInfoLabel)));
		primaryStage.show();
	}

}