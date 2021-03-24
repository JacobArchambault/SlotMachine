package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	private final ImageView blankImage = new ImageView(new Image("file:BlankFruit.png"));
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

	private final ImageView[] slotImages = new ImageView[] { blankImage, blankImage, blankImage }; // To hold the
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
		// Create a String object to hold the input
		// from the TextField.
		final var strAmountBet = insertedTextField.getText();
		// Convert the String to a double and store it
		// in the amountBet field.
		try {
			amountBet = Double.parseDouble(strAmountBet);
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
		// Initialize the slotImages array with blank images.
		for (var i = 0; i < 3; i++) {
			slotImages[i] = new ImageView(new Image("file:BlankFruit.png"));
		}

		// Put the slot images in an HBox.
		final var slotImagesHBox = new HBox(10, slotImages[0], slotImages[1], slotImages[2]);

		// Create the controls for the amount inserted.
		final var insertedPrompt = new Label("Amount Inserted: $");
		final var insertedHBox = new HBox(10, insertedPrompt, insertedTextField);
		insertedHBox.setAlignment(Pos.CENTER);

		// Create the output labels.
		final var wonThisSpinDescriptor = new Label("Amount Won This Spin: $");
		final var wonThisSpinHBox = new HBox(10, wonThisSpinDescriptor, wonThisSpinOutputLabel);
		wonThisSpinHBox.setAlignment(Pos.CENTER);

		final var totalWonDescriptor = new Label("Total Amount Won: $");
		final var totalWonHBox = new HBox(10, totalWonDescriptor, totalWonOutputLabel);
		totalWonHBox.setAlignment(Pos.CENTER);

		// Create the Spin button.
		final var spinButton = new Button("Spin");

		// Register the event handler.
		spinButton.setOnAction(e -> {
			// Get the amount bet.
			getAmountBet();
			// Determine if the bet was valid.
			if (isValidBet) {
				// Display the slots.
				displaySlots();
				// Determine the winnings.
				determineWinnings();
			}
		});

		// Create a Label for instructions and game results.
		// Put everything into a VBox
		final var mainVBox = new VBox(10, slotImagesHBox, insertedHBox, wonThisSpinHBox, totalWonHBox, spinButton,
				displayInfoLabel);
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setPadding(new Insets(10));
		primaryStage.setScene(new Scene(mainVBox));
		primaryStage.show();
	}
}