package com.jacobarchambault.slotmachine;

final class Spin {

	private static boolean threeMatch(final int[] slotMemory) {
		return slotMemory[0] == slotMemory[1] && slotMemory[0] == slotMemory[2];
	}

	private static boolean twoMatch(final int[] slotMemory) {
		return slotMemory[0] == slotMemory[1] || slotMemory[0] == slotMemory[2] || slotMemory[1] == slotMemory[2];
	}

	static int numberOfMatches(final int[] slotMemory) {
		return Spin.threeMatch(slotMemory) ? 3 : Spin.twoMatch(slotMemory) ? 2 : 0;
	}

	private Spin() {
	}

}
