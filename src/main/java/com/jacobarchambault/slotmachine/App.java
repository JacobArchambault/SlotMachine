package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
			new ImageView(images[2]) }; // To hold the
	private double totalWinnings = 0;

	// To hold the Image objects
	Label displayInfoLabel = new Label("Insert an amount to play.");
	// Controls
	TextField insertedTextField = new TextField();
	// To hold the total winnings

	// ImageView
	// components
	// Arrays
	Slots slots = new Slots(new Random(), slotImages, images);
	Label totalWonOutputLabel = new Label("0.00");

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
										new EventButton(
												"Spin",
												e -> {
													// Determine if the bet was valid.
													// Display the slots.
													try {
														// Determine the winnings.
														final var amountWon = determineWinnings(
																Double.parseDouble(insertedTextField.getText()),
																displayText(slots.numberOfMatches(slots.spin())));
														// Display the winnings.
														wonThisSpinOutputLabel
																.setText(String.format("$%,.2f", amountWon));
														totalWinnings += amountWon;
														totalWonOutputLabel
																.setText(String.format("$%,.2f", totalWinnings));
													} catch (final Exception ex) {
														displayInfoLabel.setText("Error. Try a different amount.");
													}

												}),
										displayInfoLabel)));
		primaryStage.show();
	}

	// The determineWinnings method determines the winnings.
	private double determineWinnings(final double amountBet, final int matches) {
		return amountBet * matches;
	}



	int displayText(int forMatchNumber) {
		displayInfoLabel
				.setText(
						forMatchNumber == 3 ? "Jackpot! TRIPLE WIN x 3!!"
								: forMatchNumber == 2 ? "Sweet! DOUBLE WIN x 2!!" : "No Luck. Play again!");
		return forMatchNumber;
	}

}