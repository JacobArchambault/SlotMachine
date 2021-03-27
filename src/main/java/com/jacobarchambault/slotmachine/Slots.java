package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Slots {

	private final Image[] images;
	private final Random rand;
	private final ImageView[] displays;

	Slots(final Random random, final Image[] images, final ImageView[] slots) {
		rand = random;
		this.images = images;
		this.displays = slots;
	}

	int[] spin() {
		return rand.ints(0, images.length).limit(displays.length).toArray();
	}

	void change(final int[] spinResults) {
		for (var i = 0; i < displays.length; i++) {
			displays[i].setImage(images[spinResults[i]]);
		}
	}

}
