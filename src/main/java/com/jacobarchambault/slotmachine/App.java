package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

	private double amountBet = 0;
	// To hold the Image objects
	private final Image blankImage = new Image("file:BlankFruit.png");
	Label displayInfoLabel = new Label("Insert an amount to play.");

	// To hold the slot values
	private final Image[] images = new Image[] { new Image("file:Apple.png"), new Image("file:Banana.png"),
			new Image("file:Cherries.png"), new Image("file:Grapes.png"), new Image("file:Lemon.png"),
			new Image("file:Lime.png"), new Image("file:Orange.png"), new Image("file:Pear.png"),
			new Image("file:Strawberry.png"), new Image("file:Watermelon.png") };
	// Controls
	TextField insertedTextField = new TextField();
	// To hold the total winnings
	private boolean isValidBet = false;
	// To hold the status of a bet

	private final ImageView[] slotImages = new ImageView[] { new ImageView(blankImage), new ImageView(blankImage),
			new ImageView(blankImage) }; // To hold the
	// ImageView
	// components
	// Arrays
	private final int[] slotMemory = new int[3];

	private double totalWinnings = 0;
	Label totalWonOutputLabel = new Label("0.00");

	Label wonThisSpinOutputLabel = new Label("0.00");

	// The determineWinnings method determines the winnings.
	private void determineWinnings() {
		// Determine the winnings.
		var amountWon = 0D;
		if (slotMemory[0] == slotMemory[1] && slotMemory[0] == slotMemory[2]) {// If three of the images match, the user
																				// has won
																				// three times the amount entered.
			amountWon = amountBet * 3;
			// Display the instructions.
			displayInfoLabel.setText("Jackpot! TRIPLE WIN x 3!!");
		} else if (slotMemory[0] == slotMemory[1] || slotMemory[0] == slotMemory[2] || slotMemory[1] == slotMemory[2]) {
			// If two of the images match, the user has won
			// two times the amount entered.
			amountWon = amountBet * 2;
			displayInfoLabel.setText("Sweet! DOUBLE WIN x 2!!");
		} else {
			// If none of the randomly displayed images match,
			// the user has won $0.
			amountWon = 0;
			displayInfoLabel.setText("No Luck. Play again!");
		}
		// Keep a running total of the winnings.
		totalWinnings += amountWon;
		// Display the winnings.
		wonThisSpinOutputLabel.setText(String.format("%,.2f", amountWon));
		totalWonOutputLabel.setText(String.format("%,.2f", totalWinnings));
	}

	// The displaySlots method displays the slots.
	private void displaySlots() {
		// Create a Random object.
		final var rand = new Random();
		// Create random slots.
		for (var col = 0; col < 3; col++) {
			// Generate a random number.
			final var val = rand.nextInt(10);
			// Set the slot value in memory.
			slotMemory[col] = val;
			// Set the slot image to display.
			slotImages[col].setImage(images[val]);
		}
	}

	// The getAmountBet method converts the text to
	// a double and stores it in the amountBet field.
	private void getAmountBet() {
		// Convert the String to a double and store it
		// in the amountBet field.
		try {
			amountBet = Double.parseDouble(insertedTextField.getText());
			// Set the bet status to true.
			isValidBet = true;
		} catch (NullPointerException | NumberFormatException ex) {
			// Display the an error message.
			displayInfoLabel.setText("Error. Try a different amount.");
			// Set the bet status to false.
			isValidBet = false;
		}
	}

	@Override
	public void start(final Stage primaryStage) {
		primaryStage
				.setScene(
						new Scene(
								new MainVBox(
										10,
										new HBox(10, slotImages[0], slotImages[1], slotImages[2]),
										new CenteredHBox(10, new Label("Amount Inserted: $"), insertedTextField),
										new CenteredHBox(
												10,
												new Label("Amount Won This Spin: $"),
												wonThisSpinOutputLabel),
										new CenteredHBox(10, new Label("Total Amount Won: $"), totalWonOutputLabel),
										new EventButton(
												"Spin",
												e -> {
													// Get the amount bet.
													getAmountBet();
													// Determine if the bet was valid.
													if (isValidBet) {
														// Display the slots.
														displaySlots();
														// Determine the winnings.
														determineWinnings();
													}
												}),
										displayInfoLabel)));
		primaryStage.show();
	}
}