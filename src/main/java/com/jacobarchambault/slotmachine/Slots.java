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
		int[] slotMemory =  rand.ints(0, 10).limit(3).toArray();
		for (var col = 0; col < 3; col++) {
			slotImages[col].setImage(images[slotMemory[col]]);
		}
		return slotMemory;
	}

}
