package com.jacobarchambault.slotmachine;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class SlotImages {

	Random random;
	ImageView[] displays;

	SlotImages(Random random, ImageView[] displays) {
		this.random = random;
		this.displays = displays;
	}

	int[] getRandomIndices(Image[] images) {
		return random.ints(0, images.length).limit(displays.length).toArray();
	}

	void shuffle(final int[] spinResults, Image[] images) {
		for (var i = 0; i < displays.length; i++) {
			displays[i].setImage(images[spinResults[i]]);
		}
	}

}
