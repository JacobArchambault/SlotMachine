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

	private static boolean threeMatch(final int[] slotMemory) {
		return slotMemory[0] == slotMemory[1] && slotMemory[0] == slotMemory[2];
	}

	private static boolean twoMatch(final int[] slotMemory) {
		return slotMemory[0] == slotMemory[1] || slotMemory[0] == slotMemory[2] || slotMemory[1] == slotMemory[2];
	}

	static int numberOfMatches(final int[] slotMemory) {
		return threeMatch(slotMemory) ? 3 : twoMatch(slotMemory) ? 2 : 0;
	}

}
