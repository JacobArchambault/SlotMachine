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
	// Arrays
	private int[] slotMemory;
	// To hold the slot values
	private Image[] images = new Image[] { new Image("file:Apple.png"), new Image("file:Banana.png"),
			new Image("file:Cherries.png"), new Image("file:Grapes.png"), new Image("file:Lemon.png"),
			new Image("file:Lime.png"), new Image("file:Orange.png"), new Image("file:Pear.png"),
			new Image("file:Strawberry.png"), new Image("file:Watermelon.png") };
	// To hold the Image objects
	private ImageView[] slotImages; // To hold the ImageView components

	// Betting-related fields
	private double amountBet;
	// To hold the amount bet
	private double amountWon;
	// To hold the amount won
	private double totalWinnings;
	// To hold the total winnings
	private boolean isValidBet;
	// To hold the status of a bet

	// Controls
	TextField insertedTextField;
	Label displayInfoLabel;
	Label wonThisSpinOutputLabel;
	Label totalWonOutputLabel;

	@Override
	public void start(Stage primaryStage) {
		// Set all amounts to zero.
		amountBet = 0;
		amountWon = 0;
		totalWinnings = 0;
		// Set the bet status to false.
		isValidBet = false;
		// Create an array of ints to represent
		// the slot machine in memory.
		slotMemory = new int[3];

		// Create an array of ImageView controls
		// to represent the visible slots.
		slotImages = new ImageView[3];

		// Initialize the slotImages array with blank images.
		for (int i = 0; i < 3; i++) {
			slotImages[i] = new ImageView(new Image("file:BlankFruit.png"));
		}

		// Put the slot images in an HBox.
		HBox slotImagesHBox = new HBox(10, slotImages[0], slotImages[1], slotImages[2]);

		// Create the controls for the amount inserted.
		Label insertedPrompt = new Label("Amount Inserted: $");
		insertedTextField = new TextField();
		HBox insertedHBox = new HBox(10, insertedPrompt, insertedTextField);
		insertedHBox.setAlignment(Pos.CENTER);

		// Create the output labels.
		Label wonThisSpinDescriptor = new Label("Amount Won This Spin: $");
		wonThisSpinOutputLabel = new Label("0.00");
		HBox wonThisSpinHBox = new HBox(10, wonThisSpinDescriptor, wonThisSpinOutputLabel);
		wonThisSpinHBox.setAlignment(Pos.CENTER);

		Label totalWonDescriptor = new Label("Total Amount Won: $");
		totalWonOutputLabel = new Label("0.00");
		HBox totalWonHBox = new HBox(10, totalWonDescriptor, totalWonOutputLabel);
		totalWonHBox.setAlignment(Pos.CENTER);

		// Create the Spin button.
		Button spinButton = new Button("Spin");

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
		displayInfoLabel = new Label("Insert an amount to play.");
		// Put everything into a VBox
		VBox mainVBox = new VBox(10, slotImagesHBox, insertedHBox, wonThisSpinHBox, totalWonHBox, spinButton,
				displayInfoLabel);
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setPadding(new Insets(10));
		// Add the main VBox to a scene.
		Scene scene = new Scene(mainVBox);
		// Set the scene to the stage aand display it.
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

	// The getAmountBet method converts the text to
	// a double and stores it in the amountBet field.
	private void getAmountBet() {
		// Create a String object to hold the input
		// from the TextField.
		String strAmountBet = insertedTextField.getText();
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

	// The displaySlots method displays the slots.
	private void displaySlots() {
		// Create a Random object.
		Random rand = new Random();
		// Create random slots.
		for (int col = 0; col < 3; col++) {
			// Generate a random number.
			int val = rand.nextInt(10);
			// Set the slot value in memory.
			slotMemory[col] = val;
			// Set the slot image to display.
			slotImages[col].setImage(images[val]);
		}
	}

	// The determineWinnings method determines the winnings.
	private void determineWinnings() {
		// Determine the winnings.
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
}