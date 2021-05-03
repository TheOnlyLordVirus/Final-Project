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
		checkfence, inspectfence, climbfence, inspectgenerator, checkgenerator, turnoffgenerator, lookgenerator,
		lookfence, gogenerator, movegenerator, walkgenerator, searchgenerator, searchfence, gogate, checkgate,
		movegate, walkgate, climbgate, goguard, moveguard, checkguard, walkguard, climbguard, inspectguard,
		searchgate, searchguard, inspectgate, gofence, walkfence, movefence
	}

	// The constructor will set the Location Name and Description for each scene.
	public Yard() {
		this.LocationName = "Psych Ward Yard";
		this.LocationDescription = "You are now outside of the Psych Ward there is no way of returning back.\n"
				+ "You see a tall fence that covers the entire yard of the Psych Ward preventing your escape.\n"
				+ "You see a generator that is near the fence.\n"
				+ "You see a gate with an active guard post next to it.\n"
				+ "You proably should avoid going near the active guard.";
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
		case gofence:
		case walkfence:
		case movefence:
			
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
		
		// Turn off generator command
		case turnoffgenerator:
			
			// Check if power is still on
			if (power == true) {
				
				// Change power to off
				power = false;
				
				// Update location
				GameManager.location();
				
				// Update description
				this.LocationDescription = "You are now outside of the Psych Ward there is no way of returning back.\n"
						+ "You see a tall fence that covers the entire yard of the Psych Ward preventing your escape.\n"
						+ "You see a gate with a guard post next to it.\nYou see a deactivated generator that is near the fence.";
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("Response:");
				Escape_The_Psych_Ward.iPrintLn("You have turn off the generator.");
				
			}
			else {
					
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You have already turn off the generator!");
			}
			
			break;
		
		// Going near gate commands
		case gogate:
		case movegate:
		case walkgate:
		case climbgate:
		case inspectgate:
		case checkgate:
		case checkguard:
		case inspectguard:
		case searchguard:
		case searchgate:
		case moveguard:
		case climbguard:
		case walkguard:
		case goguard:
			
			// End game
			GameManager.gameHasEnded();
			
			// Print bad ending messages
			Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
			Escape_The_Psych_Ward.iPrintLn("You went near the gate with the active guard post");
			Escape_The_Psych_Ward.iPrintLn("You accidentally step on a stick which made a loud noise.");
			Escape_The_Psych_Ward.iPrintLn("The guard freaks out and pulls out his pistol.");
			Escape_The_Psych_Ward.iPrintLn("Since the guard was smoking weed at the time he mistakes you as an alien!");
			Escape_The_Psych_Ward.iPrintLn("The guard thinks you where going to suck his brain dry so he shoots you.");
			Escape_The_Psych_Ward.iPrintLn("You drop to the floor with several bullet wounds and bleed out.");
			Escape_The_Psych_Ward.iPrintLn("The End.");
			Escape_The_Psych_Ward.iPrintLn("");
			Escape_The_Psych_Ward.iPrintLn("Tip: Some areas should not be travel at all.");
			Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
			
			// Print in log
			Logger.addLog("Bad Ending: Gate / Guard Post");
			
			break;
			
			
		// Inspect generator commands
		case inspectgenerator:
		case checkgenerator:
		case lookgenerator:
		case gogenerator:
		case movegenerator:
		case walkgenerator:
		case searchgenerator:
			
			// Check if power is still on
			if (power == true) {
				
				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You inspected the generator that is near the fence.");
				Escape_The_Psych_Ward.iPrintLn("You notice a giant wire comming out of the generator that connects it to the fence which is electrifying it.");
				Escape_The_Psych_Ward.iPrintLn("You also notice a switch that could turn off the generator.");
				
			}
			else {
					
				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You inspected the generator that is near the fence.");
				Escape_The_Psych_Ward.iPrintLn("Its been turn off already.");
			}
			
			break;
		
		// Inspect fence commands
		case checkfence:
		case inspectfence:
		case lookfence:
		case searchfence:
			
			// Print messages
			Escape_The_Psych_Ward.iPrintLn("You inspected the fence that surrounds the entire yard.");
			Escape_The_Psych_Ward.iPrintLn("You think the fence is climbable but you notice a sign that says: warning electric fence.");
			Escape_The_Psych_Ward.iPrintLn("You might want to make sure the fence is not electrify before climbing.");
			
			break;
		}
	}
}

