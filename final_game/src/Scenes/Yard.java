package Scenes;

import Core.GameManager;
import Core.Logger;
import start.Escape_The_Psych_Ward;

/**
 * Yard class extends Scene
 */
public class Yard extends Scene {

	enumCombination currentCombination;
	
	boolean power = true;

	// Combinations for user input on this scene.
	enum enumCombination {
		checkfence, inspectfence, climbfence, inspectgenerator, checkgenerator, turnoffgenerator
	}

	// The constructor will set the Location Name and Description for each scene.
	public Yard() {
		this.LocationName = "Psych Ward Yard";
		this.LocationDescription = "You are now outside of the Psych Ward there is no way of returning back.\n"
				+ "You see a tall fence that covers the entire yard of the Psych Ward preventing your escape.\n"
				+ "You see a gate with a guard post next to it.\nYou see a generator that is near the fence.";
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
	 * @throws Exception 
	 */
	@Override
	public void interaction() {
		switch (currentCombination) {
		
		// climb fence command
		case climbfence:
			
			// Check the time
			if (power == false) {

				// End game
				GameManager.gameHasEnded();
				
				// Print bad ending messages
				Escape_The_Psych_Ward.iPrintLn("Good Ending:");
				Escape_The_Psych_Ward.iPrintLn("You climb up the inactive electric fence.");
				Escape_The_Psych_Ward.iPrintLn("After reaching the otherside of the fence you made a ran for it.");
				Escape_The_Psych_Ward.iPrintLn("By the time the Psych ward realizes that you have escape you where long gone.");
				Escape_The_Psych_Ward.iPrintLn("They where never able to track you down.");
				Escape_The_Psych_Ward.iPrintLn("The End.");
				
				// Print in log
				Logger.addLog("Good Ending: Fence");

			} else {
				
				// End game
				GameManager.gameHasEnded();
				
				// Print bad ending messages
				Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
				Escape_The_Psych_Ward.iPrintLn("You decided to climb the electric fence when it was still active.");
				Escape_The_Psych_Ward.iPrintLn("You have been ZAP with electricity.");
				Escape_The_Psych_Ward.iPrintLn("You drop to the ground and died.");
				Escape_The_Psych_Ward.iPrintLn("The End.");
				Escape_The_Psych_Ward.iPrintLn("");
				Escape_The_Psych_Ward.iPrintLn("Tip: Don't climb an active electric fence...");
				Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
				
				// Print in log
				Logger.addLog("Bad Ending: Fence");
			}
			
			break;
		
		case turnoffgenerator:
			
			// Check if power is still on
			if (power == true) {
				
				// Change power to off
				power = false;
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You have turn off the generator.");
				
			}
			else {
					
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You have already turn off the generator!");
			}
			
			break;
		
		case inspectgenerator:
		case checkgenerator:
			
			// Check if power is still on
			if (power == true) {
				
				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You inspected the generator that is near the fence.");
				Escape_The_Psych_Ward.iPrintLn("You notice a giant wire comming out of the generator that connects it to the fence which is electrifying it.");
				Escape_The_Psych_Ward.iPrintLn("You also notice a switch that could turn off the generator.");
				
			}
			else {
					
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You inspected the genrator that is near the fence.");
				Escape_The_Psych_Ward.iPrintLn("Its been turn off already.");
			}
			
			break;
		
		case checkfence:
		case inspectfence:
			
			// Print messages
			Escape_The_Psych_Ward.iPrintLn("You inspected the fence that surrounds the entire yard.");
			Escape_The_Psych_Ward.iPrintLn("You think the fence is climbable but you notice a sign that says: warning electric fence.");
			Escape_The_Psych_Ward.iPrintLn("You might want to make sure the fence is not electrify before climbing.");
			
			break;
		}
	}
}

