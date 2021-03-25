package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Slots {

	Random rand;
	ImageView[] slotImages;
	Image[] images;

	Slots(Random random, ImageView[] slotImages, Image[] images) {
		this.rand = random;
		this.slotImages = slotImages;
		this.images = images;
	}

	int[] spin() {
		int[] slotMemory = new int[3];
		for (var col = 0; col < 3; col++) {
			// Generate a random number.
			final var val = rand.nextInt(10);
			// Set the slot value in memory.
			slotMemory[col] = val;
			// Set the slot image to display.
			slotImages[col].setImage(images[val]);
		}
		return slotMemory;
	}

}
