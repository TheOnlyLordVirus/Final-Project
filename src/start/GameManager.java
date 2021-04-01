package start;

import java.util.Scanner;

/**
 * Runs and holds all the objects and features to operate the game
 *
 */
public class GameManager {
	private gameState currentGameState = gameState.open;
	private String userInput;

	enum gameState {
		open, start, option1, option2, option3, error
	}

	/**
	 * The constructor.
	 */
	GameManager() {
		
		gameStateTransmission();
	}

	/*
	 * Converts a String / returns a gameState This will be where our games command
	 * structure is controlled.
	 */
	private gameState toGameState(String Command) {
		switch (Command) {
		case "start":
			return gameState.start;

		case "1":
			return gameState.option1;

		case "2":
			return gameState.option2;

		case "3":
			return gameState.option3;

		default:
			return currentGameState;
		}

	}

	// Calculates the logic for the current game state.
	private void gameStateTransmission() {
		gameStateSwitch();
	}

	// Calculates the logic for the current game state.
	private void gameStateTransmission(String Command) {
		currentGameState = toGameState(Command);
		gameStateSwitch();
	}

	/**
	 * Runs the logic for the current game state conditions.
	 */
	private void gameStateSwitch()
	{
		switch(currentGameState)
		{
			// Game has been opened
			case open:
			
			startScreen();
				
			break;
		
			// Start of the game instructions.
			case start:
				
			break;
			
			// Option 1 instructions.
			case option1:
				
				break;
			
			// Option 2 - instructions.
			case option2:
				
				break;
			
			// Option 3 - Credits.
			case option3:
				Escape_The_Psych_Ward.iPrintLn("Test");
				break;
				
			// Null?
			default:
				break;
		}
	}

	/**
	 * enterCommand Method
	 * 
	 * @param userInput
	 */
	public void enterCommand(String userInput) 
	{
		Escape_The_Psych_Ward.clearLn();
		this.userInput = userInput;
		gameStateTransmission(userInput);
	}

	/**
	 * Start Game Method
	 */
	private void startScreen() 
	{

		// Print messages
		Escape_The_Psych_Ward.iPrintLn("Main Menu");
		Escape_The_Psych_Ward.iPrintLn(" Enter the corresponding number to perform one of the following options.");
		Escape_The_Psych_Ward.iPrintLn("  Option 1 - Start Game");
		Escape_The_Psych_Ward.iPrintLn("  Option 2 - Tutorial");
		Escape_The_Psych_Ward.iPrintLn("  Option 3 - Credits");
	}
}
