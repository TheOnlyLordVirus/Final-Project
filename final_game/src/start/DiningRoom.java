package start;


/**
 * Cafeteria Room Class extends Scene
 */
public class DiningRoom extends Scene {
	
	enumCombination currentCombination;

	// Combinations for user input on this scene.
	enum enumCombination {
		opendoor, inspectdoor, jump, movepsychroom, leaveroom
	}

	// The constructor will set the Location Name and Description for each scene.
	DiningRoom() {
		
		// Set location name and description
		this.LocationName = "Dining Room";
		this.LocationDescription = "You at the dining room.\nYou can see some security guards and mental patients roaming about the room.\nYou have notice one patient in particular that has a metal file that could be useful.\nYou can also go back to the psych room if you want.";
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
		
		case movepsychroom:
		case leaveroom:
			
			// Move to psych room
			GameManager.currentLocation = "Psych Room";
			GameManager.location();
			Escape_The_Psych_Ward.iPrintLn("You have went back to your psych room.");
			break;
			
		// Null?
		default:
			
			// Print message 
			Escape_The_Psych_Ward.iPrintLn("You can't do that.");
			break;
		}
	}
}
