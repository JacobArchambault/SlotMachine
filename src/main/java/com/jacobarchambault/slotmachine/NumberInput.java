package com.jacobarchambault.slotmachine;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

class NumberInput extends TextField {

	NumberInput(){
		textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
	}
	double determineWinnings(final int matches) throws NumberFormatException {
		return Double.parseDouble(getText()) * matches;
	}

}
