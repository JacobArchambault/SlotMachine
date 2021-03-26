package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Slots {

	private final Image[] images;
	private final Random rand;
	private final ImageView[] slots;

	Slots(final Random random, final Image[] images, final ImageView[] slots) {
		rand = random;
		this.images = images;
		this.slots = slots;
	}

	int[] spin() {
		return rand.ints(0, images.length).limit(slots.length).toArray();
	}

}
