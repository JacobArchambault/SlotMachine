package com.jacobarchambault.slotmachine;

public class Spin {
	Slots slots;

	Spin(Slots slots) {
		this.slots = slots;
	}
	
	int numberOfMatches() {
		int[] slotMemory = slots.spin();
		return threeMatch(slotMemory) ? 3 : twoMatch(slotMemory) ? 2 : 0;
	}

	private static boolean threeMatch(final int[] slotMemory) {
		return slotMemory[0] == slotMemory[1] && slotMemory[0] == slotMemory[2];
	}

	private static boolean twoMatch(final int[] slotMemory) {
		return slotMemory[0] == slotMemory[1] || slotMemory[0] == slotMemory[2] || slotMemory[1] == slotMemory[2];
	}



}
