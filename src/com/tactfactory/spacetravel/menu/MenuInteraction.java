package com.tactfactory.spacetravel.menu;

import java.util.Scanner;

public class MenuInteraction {

	// Singleton start
    private MenuInteraction()
    {}

    private static MenuInteraction INSTANCE = new MenuInteraction();

    public static MenuInteraction getInstance()
    {   return INSTANCE;
    }

    // Singleton end

    public static final String MENU_CONTINUE = "\nEntrer pour continuer...\n";
    public static final String MENU_DELIMITERS = "-----------------------";
    public static final String ACTION_LEAVE = "exit : quitter le menu";

    private Scanner scanner = new Scanner(System.in);

	/**
	 * @return the scanner
	 */
	public Scanner getScanner() {
		return scanner;
	}

	/**
	 * @param scanner the scanner to set
	 */
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public String menuInteract(Menu menu){
		String result = "";
		do {
			System.out.println(menu.getDisplay());
			result = this.scanner.nextLine();
		} while (!menu.checkResult(result));
		menu.interact(result);
		this.menuContinue();
		return result;
	}

	public void menuContinue(){
		System.out.println(MENU_CONTINUE);
		this.scanner.nextLine();
	}
}
