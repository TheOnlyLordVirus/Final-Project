package Scenes;

import Core.GameManager;
import Core.Logger;
import Core.TimeTracker;
import start.Escape_The_Psych_Ward;

/**
 * PsychRoom Class extends Scene
 */
public class PsychRoom extends Scene {

	// Variables
	private boolean ventOpen = false;
	private boolean windowOpen = false;

	enumCombination currentCombination;

	// Combinations for user input on this scene.
	enum enumCombination {
		opendoor, closedoor, inspectdoor, jump, inspectfloor, inspectbed, inspectclock, sleepbed, walkroom,
		inspectwindow, lookwindow, checkwindow, openwindow, movewindow, inspectvent, crawlvent, movevent, openvent, 
		movediningroom, movedining, godining, godiningroom, checkvent, checkdoor, checkbed, checkclock, godoor, movedoor,
		unscrewvent, usescrewdriver, goyard, moveyard, gowindow, climbwindow, gooutside, moveoutside, usemetalfile, usefile,
		filewindow, filebars, gooffice, moveoffice, govent, walkvent, walkdining, walkdoor, walkoffice, walkofficeroom, walkwindow,
		walkdiningroom, walkyard, walkoutside, jumpwindow, lookvent, lookbed, lookclock, lookdoor
	}
	
	/**
	 * The constructor will set the Location Name and Description for each scene.
	 */
	public PsychRoom() {
		this.LocationName = "Psych Room";
		this.LocationDescription = "You are in your own psych room.\n"
				+ "You see your own bed in the corner.\n"
				+ "You see a clock mounted on the wall.\n"
				+ "You see a door that leads to the dining room.\n"
				+ "You see a window with metal bars.\n"
				+ "You see a vent on the backside of your room.";
	}

	/**
	 * ParseCombination method
	 */
	@Override
	public void ParseCombination(String parseToCombination) {
		currentCombination = enumCombination.valueOf(parseToCombination);
	}

	/**
	 * Interaction method performs action based on combination given
	 */
	@Override
	public void interaction() {
		switch (currentCombination) {

		// Open door command
		case opendoor:

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 0) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is locked and cannot be opened.");

			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is already open...");
			}

			break;
			
		// Move to yard commands
		case movewindow:
		case climbwindow:
		case gowindow:
		case gooutside:
		case moveoutside:
		case goyard:
		case moveyard:
		case walkoutside:
		case walkyard:
		case walkwindow:
		case jumpwindow:
			
			// Check if the window is open
			if (windowOpen == true) {

				// Check the time
				if (TimeTracker.dateTime.getTime().getHours() == 0) {

					// Move to office
					GameManager.currentLocation = "Yard";
					GameManager.location();
					
					// Print messages
					Escape_The_Psych_Ward.iPrintLn("You went through the window to get outside.");
					Escape_The_Psych_Ward.iPrintLn("You now outside of the psych ward with no way to return back.");

				} else {
					
					// End game
					GameManager.gameHasEnded();
					
					// Print bad ending messages
					Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
					Escape_The_Psych_Ward.iPrintLn("You went through the window to get outside.");
					Escape_The_Psych_Ward.iPrintLn("Psych ward staff quickly notice you in broad daylight and sound off the alarms.");
					Escape_The_Psych_Ward.iPrintLn("You try to flee but there was no escape.");
					Escape_The_Psych_Ward.iPrintLn("The guards eventually catch you and beat you up.");
					Escape_The_Psych_Ward.iPrintLn("You have been given a lobotomy as punishment for your actions.");
					Escape_The_Psych_Ward.iPrintLn("You now have the intelligence of a potato and incapable of thinking.");
					Escape_The_Psych_Ward.iPrintLn("The End.");
					Escape_The_Psych_Ward.iPrintLn("");
					Escape_The_Psych_Ward.iPrintLn("Tip: Some areas should only be traveled in at night!");
					Escape_The_Psych_Ward.iPrintLn("Also: Switching to your secondary weapon is faster than reloading!");
					Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
					
					// Print in log
					Logger.addLog("Bad Ending: Window");
				}
			}
			else {
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("The metal bars prevent you from exiting through the window.");
				Escape_The_Psych_Ward.iPrintLn("You need to remove the metal bars first.");
			}
		
			break;
			
		// Remove window bars commands
		case openwindow:
		case filewindow:
		case filebars:
		case usefile:
		case usemetalfile:
			
			// Check if player has a metalFile
			if(GameManager.UserItems.Exists(metalFile))
			{
				// Check if the window is open
				if (windowOpen) 
				{
					// Print message
					Escape_The_Psych_Ward.iPrintLn("You already remove the metal bars from the window!");
				} 
				
				else
				{
					// Print messages
					Escape_The_Psych_Ward.iPrintLn("You have remove the metal bars from the window using the metal file.");
					Escape_The_Psych_Ward.iPrintLn("You should be able to go outside through the window now.");
					
					// Open the window
					windowOpen = true;
				}
			}
			else {
				
				// Print Message
				Escape_The_Psych_Ward.iPrintLn("You need something to remove the metal bars of the window.");
			}
			
			break;

		// Inspect vent commands
		case inspectvent:
		case checkvent:
		case lookvent:

			// Check if the vent is open
			if (ventOpen == true) {

				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You inspected the vent that you have opened. Looks like you can crawl through it.");
				Escape_The_Psych_Ward.iPrintLn("You might be able to travel to the different parts of the Psych Ward using the vents.");
				Escape_The_Psych_Ward.iPrintLn("It might be a good idea to wait until nightime before going through the vent to attract less attention.");
				
			} else {

				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You inspected the vent.");
				Escape_The_Psych_Ward.iPrintLn("You noticed the four screws that are holding it in place.");
				Escape_The_Psych_Ward.iPrintLn("Maybe you can find something that can remove the screws.");
			}
			break;

		// Unscrew vent commands
		case openvent:
		case unscrewvent:
		case usescrewdriver:

			// Check if player has a screwdriver
			if(GameManager.UserItems.Exists(myScrewdriver))
			{
				// Check if the vent is open
				if (ventOpen) 
				{
					// Print message
					Escape_The_Psych_Ward.iPrintLn("You already open the vent!");	
				} 
				
				else
				{
					// Open vent
					Escape_The_Psych_Ward.iPrintLn("You have opened the vent using the screwdriver.");
					ventOpen = true;
				}
			}
			
			else
			{
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You need something to remove the screws on the vent.");
			}

			break;

		// Crawl through vent commands
		case crawlvent:
		case movevent:
		case govent:
		case moveoffice:
		case gooffice:
		case walkoffice:
		case walkvent:

			// Check if the vent is open
			if (ventOpen == true) {

				// Check the time
				if (TimeTracker.dateTime.getTime().getHours() == 0) {

					// Move to office
					GameManager.currentLocation = "Office Room";
					GameManager.location();
					Escape_The_Psych_Ward.iPrintLn("You have crawl through the vent unitl you have reach into different room.");
					Escape_The_Psych_Ward.iPrintLn("You appear to be in an office.");

				} else {
					
					// End game
					GameManager.gameHasEnded();
					
					// Print bad ending messages
					Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
					Escape_The_Psych_Ward.iPrintLn("You have crawl through the vent until you have reach into a different room.");
					Escape_The_Psych_Ward.iPrintLn("Once you have crawl out the vent you hear the screaming of psych staff.");
					Escape_The_Psych_Ward.iPrintLn("Before you could do anything the psych ward guards rush in and started to beat you up.");
					Escape_The_Psych_Ward.iPrintLn("You have been given a lobotomy as punishment for your actions.");
					Escape_The_Psych_Ward.iPrintLn("You now have the intelligence of a potato and incapable of thinking.");
					Escape_The_Psych_Ward.iPrintLn("The End.");
					Escape_The_Psych_Ward.iPrintLn("");
					Escape_The_Psych_Ward.iPrintLn("Tip: Some areas should only be traveled at night.");
					Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
					
					// Print in log
					Logger.addLog("Bad Ending: Vent");
				}
			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The vent needs to be open before you can crawl in it.");
			}

			break;

		// Move to dining commands
		case movedining:
		case movediningroom:
		case godining:
		case godiningroom:
		case movedoor:
		case godoor:
		case walkdoor:
		case walkdiningroom:
		case walkdining:
			
			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 0) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is closed so you can't go to the cafeteria room right now.");

			} else {

				// Move to dining room
				GameManager.currentLocation = "Dining Room";
				GameManager.location();
				Escape_The_Psych_Ward.iPrintLn("You have exit your room and went to the dining room.");
			}
			
			break;

		// Inspect door commands
		case inspectdoor:
		case checkdoor:
		case lookdoor:

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 0) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is closed and locked for the night.");

			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is open you can go to the dining room.");
			}
			break;

		// Jump command
		case jump:
			jump();
			break;

		// Inspect window commands
		case inspectwindow:
		case lookwindow:
		case checkwindow:

			// Print messages
			Escape_The_Psych_Ward.iPrintLn("You inspected the window in your psych room.");

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 12) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("You see the outside world with the bright sun's gaze.");
				
			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("You see the outside world with the glow of the moon and the darkness surrounding it.");
			}
			
			// Check if window was open
			if (windowOpen == true) {
				
				// Print messages
				Escape_The_Psych_Ward.iPrintLn("The metal bars on the window have been removed.");
				Escape_The_Psych_Ward.iPrintLn("You should be able to climb out the window to reach outside.");
				
			}
			else {
				
				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You notice that the metal bars on the window are weak.");
				Escape_The_Psych_Ward.iPrintLn("Maybe you can find something to break the metal bars on the window.");
			}

			break;

		// Inspect clock commands
		case inspectclock:
		case checkclock:
		case lookclock:

			// Print message
			Escape_The_Psych_Ward.iPrintLn("You inspected the clock.");
			Escape_The_Psych_Ward.iPrintLn("The time is " + TimeTracker.dateTime.getTime().getHours() + " clock.");

			break;
		
		// Inspect bed commands
		case inspectbed:
		case checkbed:
		case lookbed:
			
			// Print message
			Escape_The_Psych_Ward.iPrintLn("You inspected the bed.");
			
			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 12) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The bed is disgusting but its a place to sleep until night time.");
			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The bed is disgusting but its a place to sleep until morning time.");
			}

			break;

		// Sleep bed command
		case sleepbed:

			// Print message
			Escape_The_Psych_Ward.iPrintLn("You decided to sleep in your bed.");

			// Increase time
			TimeTracker.increaseTimeByHours(12);

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 12) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("It is now morning and you notice that the door in your room is now open.");
				
			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("It is now nightime and you notice that the door in your room is now closed for the night.");
			}

			break;
		}
	}
}
