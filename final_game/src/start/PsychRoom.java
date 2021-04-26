package start;

import java.util.Random;

/**
 * PsychRoom Class extends Scene
 */
public class PsychRoom extends Scene {

	// Variables
	boolean doorOpen = false;
	boolean ventOpen = false;

	enumCombination currentCombination;

	// Combinations for user input on this scene.
	enum enumCombination {
		opendoor, closedoor, inspectdoor, inspectwall, jump, inspectfloor, inspectbed, inspectclock, sleepbed,
		inspectwindow, lookwindow, inspectvent, crawlvent, movevent, openvent, movediningroom, movedining, leaveroom
	}

	// The constructor will set the Location Name and Description for each scene.
	PsychRoom() {
		this.LocationName = "Psych Room";
		this.LocationDescription = "You are in your own psych room.\nYou see your own bed in the corner.\nYou see a clock mounted on the wall.\nYou see a door that leads to the dining room.\nYou see a window with metal bars.\nYou see a vent on the backside of your room.";
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

		// Open door
		case opendoor:

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 0) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door cannot be open.");

			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is already open.");
			}

			break;

		// Inspect vent
		case inspectvent:

			// Check if the vent is open
			if (ventOpen == true) {

				// Print message
				Escape_The_Psych_Ward
						.iPrintLn("You inspected the vent that you have opened. Looks like you can crawl through it.");
			} else {

				// Print messages
				Escape_The_Psych_Ward.iPrintLn("You inspected the vent.");
				Escape_The_Psych_Ward.iPrintLn("You noticed the four screws that are holding it in place.");
				Escape_The_Psych_Ward.iPrintLn("Maybe you can find something that can remove the screws.");
			}
			break;

		// Open vent
		case openvent:

			// Check if the vent is open
			if (ventOpen == true) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("You already open the vent!");
			} else if (ventOpen == false) {

				// Open vent
				Escape_The_Psych_Ward.iPrintLn("You have opened the vent using the screw driver you have found.");
				ventOpen = true;

			} else {

				// Print Message
				Escape_The_Psych_Ward.iPrintLn("You need somthing to open that vent.");
			}
			break;

		// Crawl through vent
		case crawlvent:
		case movevent:

			// Check if the vent is open
			if (ventOpen == true) {

				// Check the time
				if (TimeTracker.dateTime.getTime().getHours() == 0) {

					// Move to office
					GameManager.currentLocation = "Office Room";
					GameManager.location();
					Escape_The_Psych_Ward
							.iPrintLn("You have crawl through the vent unitl you have reach into different room.");
					Escape_The_Psych_Ward.iPrintLn("You appear to be in an office.");

				} else {

					// Print bad ending
					Escape_The_Psych_Ward
							.iPrintLn("You have crawl through the vent unitl you have reach into different room.");
					Escape_The_Psych_Ward.iPrintLn(
							"Once you have crawl out the vent you hear screaming of psych staff before being beaten up by pysch ward guards.");
					Escape_The_Psych_Ward.iPrintLn(
							"You have been sent to a new Pysch Ward that you will live for rest of your life.");
					Escape_The_Psych_Ward.iPrintLn("The End.");
				}
			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The vent needs to be open before you can crawl in it.");
			}

			break;

		// Go to dining
		case movedining:
		case movediningroom:
		case leaveroom:

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 0) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is closed you can't go to the cafeteria room right now.");

			} else {

				// Move to dining room
				GameManager.currentLocation = "Dining Room";
				GameManager.location();
				Escape_The_Psych_Ward.iPrintLn("You have went to the dining room");
			}

			break;

		// inspect door
		case inspectdoor:

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 0) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is closed and locked for the night.");

			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("The door is open you can go to the dining room.");
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

		// inspect wall
		case inspectwindow:
		case lookwindow:

			// Print message
			Escape_The_Psych_Ward.iPrintLn("You inspected the window.");

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 12) {

				// Print message
				Escape_The_Psych_Ward.iPrintLn("You see the outside world with the bright sun's gaze.");
			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn(
						"You see the outside world with the glow of the moon and the darkness surrounding it.");
			}

			break;

		// inspect clock
		case inspectclock:

			// Print message
			Escape_The_Psych_Ward.iPrintLn(
					"You inspect the clock. The time is " + TimeTracker.dateTime.getTime().getHours() + " clock.");

			break;

		// Sleep in bed
		case sleepbed:

			// Print message
			Escape_The_Psych_Ward.iPrintLn("You decided to sleep in your bed.");

			// Increase time
			TimeTracker.increaseTimeByHours(12);

			// Check the time
			if (TimeTracker.dateTime.getTime().getHours() == 12) {

				// Print message
				Escape_The_Psych_Ward
						.iPrintLn("It is now morning and you notice that the door in your room is now open.");
			} else {

				// Print message
				Escape_The_Psych_Ward.iPrintLn(
						"It is now nightime and you notice that the door in your room is now closed for the night.");
			}

			break;

		// Null?
		default:

			// Print message
			Escape_The_Psych_Ward.iPrintLn("You can't do that.");
			break;
		}
	}
}
