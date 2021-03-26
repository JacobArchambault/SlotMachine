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

	// To hold the slot values
	private final Image[] images = new Image[] { new Image("file:Apple.png"), new Image("file:Banana.png"),
			new Image("file:Cherries.png"), new Image("file:Grapes.png"), new Image("file:Lemon.png"),
			new Image("file:Lime.png"), new Image("file:Orange.png"), new Image("file:Pear.png"),
			new Image("file:Strawberry.png"), new Image("file:Watermelon.png") };
	private final ImageView[] slotImages = new ImageView[] { new ImageView(images[2]), new ImageView(images[2]),
			new ImageView(images[2]) };
	DisplayLabel displayInfoLabel = new DisplayLabel("Insert an amount to play.");

	NumberInput insertedTextField = new NumberInput();
	SlotImages slimgs = new SlotImages(slotImages, images);
	Slots slots = new Slots(new Random(), images, slotImages);
	TotalWinningsLabel totalWonOutputLabel = new TotalWinningsLabel("0.00");

	Label wonThisSpinOutputLabel = new Label("0.00");

	@Override
	public void start(final Stage primaryStage) {
		primaryStage
				.setScene(
						new Scene(
								new MainVBox(
										10,
										new HBox(10, slotImages[0], slotImages[1], slotImages[2]),
										new CenteredHBox(10, new Label("Amount Inserted: "), insertedTextField),
										new CenteredHBox(
												10,
												new Label("Amount Won This Spin: "),
												wonThisSpinOutputLabel),
										new CenteredHBox(10, new Label("Total Amount Won: "), totalWonOutputLabel),
										new EventButton("Spin", e -> {
											doTheThings(slots.spin());
										}),
										displayInfoLabel)));
		primaryStage.show();
	}

	private void doTheThings(final int[] ints) {
		try {
			final var fromMatches = Spin.numberOfMatches(ints);
			final var amountWon = insertedTextField.determineWinnings(fromMatches);
			displayInfoLabel.displayText(fromMatches);
			slimgs.change(ints);
			wonThisSpinOutputLabel.setText(String.format("$%,.2f", amountWon));
			totalWonOutputLabel.displayUpdate(amountWon);
		} catch (final NumberFormatException ex) {
			displayInfoLabel.setText("Insert an amount to play.");
		}
	}

}