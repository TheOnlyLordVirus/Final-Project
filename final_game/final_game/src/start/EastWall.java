package start;

import java.util.Random;

/**
 * East Wall Class extends scene implements SceneInterface
 */
public class EastWall extends Scene {

	// Variables
	boolean dooropen = false;
	enumCombination currentCombination;

	// Combinations for user input on this scene.
	enum enumCombination {
		inspectwall, jump, movesouthwall, movenorthwall, moveeastwall, movewestwall, inspectwindow, lookwindow
	}

	// The constructor will set the Location Name and Description for each scene.
	EastWall() {
		this.LocationName = "East Wall";
		this.LocationDescription = "You are facing the East Wall, and you notice that there is a window.";
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

		// Change rooms.
		case movenorthwall:
			GameManager.currentLocation = "NorthWall";
			GameManager.clear();
			Escape_The_Psych_Ward.iPrintLn("You move to the North Wall.");
			break;

		case moveeastwall:
			Escape_The_Psych_Ward.iPrintLn("You are already at the East Wall!");
			break;

		case movesouthwall:
			GameManager.currentLocation = "SouthWall";
			GameManager.clear();
			Escape_The_Psych_Ward.iPrintLn("You move to the South Wall.");
			break;

		case movewestwall:
			GameManager.currentLocation = "WestWall";
			GameManager.clear();
			Escape_The_Psych_Ward.iPrintLn("You move to the West Wall.");
			break;

		// inspect wall
		case inspectwall:
			Escape_The_Psych_Ward.iPrintLn("You inspected the wall.");
			break;

		// inspect wall
		case inspectwindow:
		case lookwindow:
			
			// Check the time
			if(TimeTracker.dateTime.getTime().getHours() == 6) {
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You inspected the window. You see the sun begin to rise up to the sky showing the light.");
			}
			else if(TimeTracker.dateTime.getTime().getHours() == 12){
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You inspected the window. You see the sun at its peak in the sky with its bright glare.");
			}
			else if(TimeTracker.dateTime.getTime().getHours() == 18) {
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You inspected the window. You see the sun sinking down as the moon takes its place with darknes.");
			}
			else {
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You inspected the window. You see the moon and darkness.");
			}
			
			break;

		// :)
		case jump:
			Random r = new Random();

			switch (r.nextInt(3)) {
			case 0:
				Escape_The_Psych_Ward.iPrintLn("Are you happy now?");
				break;

			case 1:
				Escape_The_Psych_Ward.iPrintLn("Are you having fun now?");
				break;

			case 2:
				Escape_The_Psych_Ward.iPrintLn("Yeah! Work it real good!");
				break;
			}
			break;

		// Null?
		default:
			Escape_The_Psych_Ward.iPrintLn("You can't do that.");
			break;
		}
	}
}
