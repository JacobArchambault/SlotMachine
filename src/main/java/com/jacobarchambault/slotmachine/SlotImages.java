package com.jacobarchambault.slotmachine;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class SlotImages {
	private final Image[] images;
	private final ImageView[] slots;

	SlotImages(final ImageView[] slotImages, final Image[] images) {
		slots = slotImages;
		this.images = images;
	}

	void change(final int[] spinResults) {
		for (var i = 0; i < slots.length; i++) {
			slots[i].setImage(images[spinResults[i]]);
		}
	}
}
