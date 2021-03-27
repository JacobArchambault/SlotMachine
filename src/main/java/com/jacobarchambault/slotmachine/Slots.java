package com.jacobarchambault.slotmachine;

import javafx.scene.image.Image;

class Slots {

	private final SlotImages slotImages;
	private final Image[] images;

	Slots(SlotImages slotImages, final Image[] images) {
		this.slotImages = slotImages;
		this.images = images;
	}

	int[] spin() {
		return slotImages.getRandomIndices(images);
	}

	void updateUI(final int[] spinResults) {
		slotImages.shuffle(spinResults, images);
	}

}
