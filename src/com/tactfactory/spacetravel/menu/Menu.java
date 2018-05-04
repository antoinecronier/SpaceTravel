package com.tactfactory.spacetravel.menu;

public interface Menu {

	String getDisplay();
	Boolean checkResult(String toCheck);
	void interact(String result);
}
