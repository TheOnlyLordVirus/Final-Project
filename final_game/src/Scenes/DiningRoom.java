package Scenes;

import java.util.Random;

import javax.swing.JOptionPane;

import Core.GameManager;
import Core.Logger;
import start.Escape_The_Psych_Ward;

/**
 * Cafeteria Room Class extends Scene
 */
public class DiningRoom extends Scene {

	// Flags
	boolean lostTooth = false;
	boolean teethManiac = true;
	boolean smoker = true;
	
	// The current combination that the user input.
	enumCombination currentCombination;

	// Combinations for user input on this scene.
	enum enumCombination {
		jump, movepsychroom, movepsych, gopsych, gopsychroom, smile, talkmaniac, fightguard, punchguard,
		talkteethmaniac, speakmaniac, speakteethmaniac, talksmoker, speaksmoker, walkpsych, walkpsychroom,
		kickguard, tradesmoker, trademaniac, tradeteethmaniac, tradeteeth, tradecigarettes, tradecigarette,
		fightpatient, punchpatient, kickpatient, knockpatient, fightmaniac, punchmaniac, kickmaniac, knockmaniac, 
		knockguard, fightsmoker, punchsmoker, knocksmoker, fightteethmaniac, punchteethmaniac, knockteethmaniac,
		kickteethmaniac, kicksmoker
	}

	// The constructor will set the Location Name and Description for each scene.
	public DiningRoom() {

		// Set location name and description
		this.LocationName = "Dining Room";
		this.LocationDescription = "You at the dining room that is used for psych ward patients.\n"
				+ "You can see some security guards and mental patients that are roaming about the room.\n"
				+ "You have notice one patient in particular refer as the Teeth Maniac who has a screwdriver that could be useful.\n"
				+ "You should consider talking to the Teeth Maniac to see if you can get the screwdriver to use.\n"
				+ "You have also notice one patient in particular refer as the Smoker who has a metal file that could be useful.\n"
				+ "You should consider talking to the Smoker to see if you can get the metal file to use.\n"
				+ "You can also go back to your personal psych room if you want.";
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
	public void interaction() 
	{
		switch (currentCombination) 
		{
		
		// Fight Teeth Maniac commands
		case fightteethmaniac:
		case fightmaniac:
		case punchmaniac:
		case punchteethmaniac:
		case kickmaniac:
		case kickteethmaniac:
		case knockmaniac:
		case knockteethmaniac:
			
			// Check if teethManiac is present
			if (teethManiac) {
				
				// Print bad ending messages
				Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
				Escape_The_Psych_Ward.iPrintLn("You try to fight the teeth maniac for the screwdriver.");
				Escape_The_Psych_Ward.iPrintLn("The teeth maniac grabs your jaw and rips it out!");
				Escape_The_Psych_Ward.iPrintLn("You watch jawlessly as the maniac plays with your teeth.");
				Escape_The_Psych_Ward.iPrintLn("You fall down on the floor and bleed out.");
				Escape_The_Psych_Ward.iPrintLn("The End.");
				Escape_The_Psych_Ward.iPrintLn("");
				Escape_The_Psych_Ward.iPrintLn("Tip: Don't fight a maniac.");
				Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
				
			}
			else {
				
				// Print messages
				Escape_The_Psych_Ward.iPrintLn("The Teeth Maniac is no longer present.");
			}
			
			break;

			// Talk to teeth maniac commands
			case talkteethmaniac:
			case speakteethmaniac:
			case talkmaniac:
			case speakmaniac:
			case trademaniac:
			case tradeteethmaniac:
			case tradeteeth:
				
				// Check if teethManiac is present
				if (teethManiac)
				{
					// Check if player has tooth
					if (GameManager.UserItems.Exists(myTooth))
					{
						
						// Change Scene Description
						this.LocationDescription = "You at the dining room that is used for psych ward patients.\n"
								+ "You can see some security guards and mental patients that are roaming about the room.\n"
								+ "You have notice one patient in particular refer as the Smoker who has a metal file that could be useful.\n"
								+ "You should consider talking to the Smoker to see if you can get the metal file to use.\n"
								+ "You can also go back to your personal psych room if you want.";
						
						// Update location
						GameManager.location();
						
						// Print messages
						Escape_The_Psych_Ward.iPrintLn("You talk to the Teeth Maniac about the screwdriver and show him your tooth.");
						Escape_The_Psych_Ward.iPrintLn("He gladly accepts the offer and hands you the screwdriver quickly!");
						Escape_The_Psych_Ward.iPrintLn("You watch as he gleefully runs away to his room to play with your bloody tooth...");
						Escape_The_Psych_Ward.iPrintLn("What the hell is wrong with that guy? Why am I here?...");
						
						// Add screw driver into inventory
						GameManager.UserItems.Add(myScrewdriver);
						
						// Remove tooth from inventory
						GameManager.UserItems.Remove(myTooth);
						
						// Set that teethManiac is no longer present
						teethManiac = false;
					}
					
					else
					{
						// Print messages
						Escape_The_Psych_Ward.iPrintLn("You talk to the Teeth Maniac about the screwdriver.");
						Escape_The_Psych_Ward.iPrintLn("The Teeth Maniac blabbers something about teeth and shows no interest about your request.");
						Escape_The_Psych_Ward.iPrintLn("Maybe you can get him to trade his screwdriver by giving him some teeth.");
						Escape_The_Psych_Ward.iPrintLn("Perhaps you could try knocking your own teeth out or even someone else's teeth?");
					}
				}
				else {
					
					// Print messages
					Escape_The_Psych_Ward.iPrintLn("The Teeth Maniac is no longer present.");
				}
				
				break;
				
			// Fight smoker commands
			case fightsmoker:
			case punchsmoker:
			case kicksmoker:
			case knocksmoker:
				
				// Check if smoker is present
				if (smoker) {
					
					// Print bad ending messages
					Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
					Escape_The_Psych_Ward.iPrintLn("You try to fight the smoker for the metal file.");
					Escape_The_Psych_Ward.iPrintLn("The smoker stabs your eye with the metal file you attempt to take.");
					Escape_The_Psych_Ward.iPrintLn("You scream for help but the smoker bashs your head into the floor.");
					Escape_The_Psych_Ward.iPrintLn("The metal file goes into your brain killing you in the process.");
					Escape_The_Psych_Ward.iPrintLn("Aleast you got the metal file now but good luck using it.");
					Escape_The_Psych_Ward.iPrintLn("The End.");
					Escape_The_Psych_Ward.iPrintLn("");
					Escape_The_Psych_Ward.iPrintLn("Tip: Don't fight a smoker that wants his cigarettes.");
					Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
					
				}
				else {
					
					// Print messages
					Escape_The_Psych_Ward.iPrintLn("The Smoker is no longer present.");
				}
				
				break;
				
			// Talk to smoker commands
			case talksmoker:
			case speaksmoker:
			case tradesmoker:
			case tradecigarette:
			case tradecigarettes:
				
				// Check if smoker is present
				if(smoker)
				{
					// Check if player has ciggarette.
					if(GameManager.UserItems.Exists(smokersCiggarette))
					{
						
						// Change Scene Description
						this.LocationDescription = "You at the dining room that is used for psych ward patients.\n"
								+ "You can see some security guards and mental patients that are roaming about the room.\n"
								+ "You see no one that is worth your time.\n"
								+ "You can go back to your personal psych room if you want.";
						
						// Update location
						GameManager.location();
						
						// Print messages
						Escape_The_Psych_Ward.iPrintLn("You talk to the Smoker about the metal file.");
						Escape_The_Psych_Ward.iPrintLn("You show him the cigarettes you have found in the office room.");
						Escape_The_Psych_Ward.iPrintLn("He thanks you for finding his cigarettes and gives you his metal file.");
						Escape_The_Psych_Ward.iPrintLn("The Smoker leaves the dining room to smoke his cigarettes.");
						
						// Add metal File into inventory
						GameManager.UserItems.Add(metalFile);
						
						// Remove cigarette from inventory
						GameManager.UserItems.Remove(smokersCiggarette);
						
						// Set that smoker is no longer present
						smoker = false;
					}
					
					else
					{
						// Print messages
						Escape_The_Psych_Ward.iPrintLn("You talk to the Smoker about the metal file.");
						Escape_The_Psych_Ward.iPrintLn("The Smoker refuses to give up his metal file.");
						Escape_The_Psych_Ward.iPrintLn("But the Smoker makes you an offer to trade the metal file for some cigarettes.");
						Escape_The_Psych_Ward.iPrintLn("The Smoker claims that the psych staff have taken his last pack of cigarettes and put them in the office room.");
						Escape_The_Psych_Ward.iPrintLn("Maybe you can find a way into the office room to get his cigarettes?");	
					}
				}
				else {
					
					// Print messages
					Escape_The_Psych_Ward.iPrintLn("The Smoker is no longer present.");
				}			
				
				break;
				
	
			// Smile command
			case smile:
				
				// Check if teeth maniac is present
				if (teethManiac) {
					
					// End game
					GameManager.gameHasEnded();
					
					// Print bad ending messages
					Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
					Escape_The_Psych_Ward.iPrintLn("You decide to smile for some reason.");
					Escape_The_Psych_Ward.iPrintLn("The teeth maniac notices your smile and begins to scream TEETH!!!");
					Escape_The_Psych_Ward.iPrintLn("The teeth maniac starts to rush towards you.");
					Escape_The_Psych_Ward.iPrintLn("You try to flee and scream for help but that only delays the inevitable.");
					Escape_The_Psych_Ward.iPrintLn("The teeth maniac grabs your jaw and rips it out!");
					Escape_The_Psych_Ward.iPrintLn("You watch jawlessly as the maniac plays with your teeth.");
					Escape_The_Psych_Ward.iPrintLn("You fall down on the floor and bleed out.");
					Escape_The_Psych_Ward.iPrintLn("The End.");
					Escape_The_Psych_Ward.iPrintLn("");
					Escape_The_Psych_Ward.iPrintLn("Tip: Don't smile around a maniac...");
					Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
		
					// Print in log
					Logger.addLog("Bad Ending: Smile");
				}
				else {
					
					// Print messages
					Escape_The_Psych_Ward.iPrintLn("You decide to smile for some reason.");
					Escape_The_Psych_Ward.iPrintLn("With no Teeth Maniac present you are safe.");
				}

				break;
				
			// Fight the guard commands
			case fightguard:
			case punchguard: 
			case kickguard:
				
				// Check if user has tooth in is inventory and hasn't already lost one.
				if(!GameManager.UserItems.Exists(myTooth) && !lostTooth)
				{
					// Add tooth
					GameManager.UserItems.Add(myTooth);
					
					// Set tooth to true
					lostTooth = true;
					
					// Move to psych room
					GameManager.currentLocation = "Psych Room";
					GameManager.location();
					
					// Print messages
					Escape_The_Psych_Ward.iPrintLn("You try to fight a guard.");
					Escape_The_Psych_Ward.iPrintLn("You get punched by the guard in the jaw and one of your teeth comes flying out.");
					Escape_The_Psych_Ward.iPrintLn("You quickly grab it before being sent to your room for the day.");
				}
				
				else
				{
					// End game
					GameManager.gameHasEnded();
					
					// Print bad ending messages
					Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
					Escape_The_Psych_Ward.iPrintLn("You pick another fight with a guard, at this point the guard has already become quite agitated.");
					Escape_The_Psych_Ward.iPrintLn("Towards you and opens up at the opportunity to rock your world.");
					Escape_The_Psych_Ward.iPrintLn("With one fatal swing his fist smashes in to your face, resulting in brain hemorrhaging.");
					Escape_The_Psych_Ward.iPrintLn("You die a very painful death 3 days later in the ICU.");
					Escape_The_Psych_Ward.iPrintLn("The End.");
					Escape_The_Psych_Ward.iPrintLn("");
					Escape_The_Psych_Ward.iPrintLn("Tip: Some actions should not be repeated twice.");
					Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
		
					// Print in log
					Logger.addLog("Bad Ending: Fight Guard");
				}
				
				break;
				
				// Fight the patient commands
				case fightpatient:
				case punchpatient:
				case kickpatient:
					
					// Check if user has tooth in is inventory and hasn't already lost one.
					if(!GameManager.UserItems.Exists(myTooth) && !lostTooth)
					{
						// Add tooth
						GameManager.UserItems.Add(myTooth);
						
						// Set tooth to true
						lostTooth = true;
						
						// Move to psych room
						GameManager.currentLocation = "Psych Room";
						GameManager.location();
						
						// Print messages
						Escape_The_Psych_Ward.iPrintLn("You try to fight a patient.");
						Escape_The_Psych_Ward.iPrintLn("Before you could finsh the fight the guards shows up.");
						Escape_The_Psych_Ward.iPrintLn("You get punched by a guard in the jaw and one of your teeth comes flying out.");
						Escape_The_Psych_Ward.iPrintLn("You quickly grab it before being sent to your room for the day.");
					}
					
					else
					{
						// End game
						GameManager.gameHasEnded();
						
						// Print bad ending messages
						Escape_The_Psych_Ward.iPrintLn("Bad Ending:");
						Escape_The_Psych_Ward.iPrintLn("You pick another fight with a patient, at this point the guards has already become quite agitated");
						Escape_The_Psych_Ward.iPrintLn("Towards you and opens up at the opportunity to rock your world.");
						Escape_The_Psych_Ward.iPrintLn("With one fatal swing a guard smashes your face with his fist, resulting in brain hemorrhaging.");
						Escape_The_Psych_Ward.iPrintLn("You die a very painful death 3 days later in the ICU.");
						Escape_The_Psych_Ward.iPrintLn("The End.");
						Escape_The_Psych_Ward.iPrintLn("");
						Escape_The_Psych_Ward.iPrintLn("Tip: Some actions should not be repeated twice.");
						Escape_The_Psych_Ward.iPrintLn("Restart the application to try again!");
			
						// Print in log
						Logger.addLog("Bad Ending: Fight Patient");
					}
					
					break;
				
			// Jump commands
			case jump:
				jump();
				break;
			
			// Move back to psych room commands
			case movepsychroom:
			case movepsych:
			case gopsych:
			case gopsychroom:
			case walkpsychroom:
			case walkpsych:
				
				// Move to psych room
				GameManager.currentLocation = "Psych Room";
				GameManager.location();
				Escape_The_Psych_Ward.iPrintLn("You walk back to your personal psych room.");
				break;
	
	
			// Null?
			default:
				// Print message
				Escape_The_Psych_Ward.iPrintLn("You can't do that.");
				break;
		}
	}
}
