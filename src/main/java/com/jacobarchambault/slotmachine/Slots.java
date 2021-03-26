package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Slots {

	Image[] images;
	Random rand;
	ImageView[] slotImages;

	Slots(final Random random, final ImageView[] slotImages, final Image[] images) {
		rand = random;
		this.slotImages = slotImages;
		this.images = images;
	}

	private int lesser(final int[] slotMemory, final Object[] iv) {
		return slotMemory.length < iv.length ? slotMemory.length : iv.length;
	}

	int[] spin() {
		final var slotMemory = rand.ints(0, 10).limit(3).toArray();
		for (var col = 0; col < lesser(slotMemory, slotImages); col++) {
			slotImages[col].setImage(images[slotMemory[col]]);
		}
		return slotMemory;
	}

}
