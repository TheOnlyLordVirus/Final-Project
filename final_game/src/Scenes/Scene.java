package Scenes;

import java.util.Random;

import Core.Logger;
import Items.Cigarette;
import Items.Metalfile;
import Items.Note;
import Items.Screwdriver;
import Items.Tooth;
import start.Escape_The_Psych_Ward;

/**
 *  Base scene class used 
 */
public abstract class Scene implements SceneInterface
{
	// Protected so any of the children classes are able to use these if needed.
	protected enumMasterWordList currentWords[];
	protected String LocationName;
	protected String LocationDescription;

	// Master list of Items for the game.
	// Not sure how well this would scale for a larger game but for a small example it works...
	// - Trenton
	public final static Tooth myTooth = new Tooth();
	public final static Screwdriver myScrewdriver = new Screwdriver(); 
	public final static Cigarette smokersCigarette = new Cigarette();
	public final static Metalfile metalFile = new Metalfile();
	public final static Note passwordNote = new Note();	
	
	// All of the keywords that the user can enter in for command combinations.
	public enum enumMasterWordList
	{
		bed, clock, door, key, open, close, grab, move, inspect, hit, window,
		sleep, look, vent, crawl, dining, room, psych, check, desk, login, computer, add, record,
		database, update, delete, records, teeth, state, item, generator, turn, off, climb, fence,
		smile, lobby, main, go, unscrew, screwdriver, yard, outside, metal, file, use, office, maniac,
		talk, smoker, speak, punch, kick, fight, walk, jump, guard, patient, tooth, knock, gate, 
		trade, personal, search,
	}
	
	/**
	 * Jump method
	 */
	protected void jump()
	{
		Random r = new Random();
		
		switch(r.nextInt(3))
		{
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
	}
	
    @Override
    public String toString()
    {
    	
    	// Return location name
        return String.format("Location: " + LocationName);
    }
	
	@Override
	public String getName()
	{
		// Return location name
		return LocationName;
	}
	
	@Override
	public String getDescription() 
	{
		// Return location Description
		return LocationDescription;
	}
	
	/**
	 * The perform method will get the words from user's input.
	 * This will filter words that are not in the enumMasterWordList from the users CLI input.
	 * Then it will take the remaining words and combine them in the order that is supplied by the user
	 * If the combination of words from enumMasterWordList is in the same order as one of the combinations from the derived 'child' Scenes enumCombination
	 * Than the combination will Parse and the child Scene will run the action for that enumCombination.
	 * I hope that makes sense...
	 * - Trenton.
	 * 
	 * @param message
	 */
	public void perform(String message)
	{
		if(!message.isEmpty())
		{
			// Split the message
			String[] spliter = message.split(" ");
			String parseToCombination = "";
			
			// Define the array size.
			currentWords = new enumMasterWordList[spliter.length];

			// Loop through for all words provided
			for (int i = 0; i < spliter.length; i++) 
			{
				
				// Get words.
				try
				{
					// Attempt to parse the value of the spliter string index to a enum
					currentWords[i] = enumMasterWordList.valueOf(spliter[i]);
					
					// If we made it here it parsed correctly, otherwise any words not in the enumWordList will not be added to the Combination!
					parseToCombination += spliter[i];
				}
				
				// If this word doesn't parse from the valueOf() method to a enum
				catch (Exception Ex)
				{	
					// Print invalid word
					System.out.println("Invaild word used: " + spliter[i] + ", removing word.");
					
					// Write invalid word to log.
					Logger.addLog("Invaild word used: " + spliter[i] + ", removing word.");
				}	
			}
			
			// Get combination.
			try
			{
				// Try to parse the string to a combination!
				ParseCombination(parseToCombination);
				
				// Write message to log
				Logger.addLog("Action was performed");
				
				// If it parses perform the combination.
				interaction();
			}
			
			// If this is a failing combination 
			catch (Exception Ex)
			{
				// Print invalid combination to log
				System.out.println("Invaild word Combination: " + parseToCombination);
				
				// Write invalid combination to log
				Logger.addLog("Invaild word Combination: " + parseToCombination);
				
				// Print message
				Escape_The_Psych_Ward.iPrintLn("I do not understand this combination of words.");
			}
		}
	}
}
