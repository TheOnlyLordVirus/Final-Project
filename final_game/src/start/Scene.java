package start;

/**
 *  Scene Base Class
 *
 */
public abstract class Scene implements SceneInterface
{
	
	enumMasterWordList currentWords[];
	protected String LocationName;
	protected String LocationDescription;
	
	enum enumMasterWordList
	{
		wall, floor, bed, clock, door, key, open, close, grab, move, inspect, jump, bookshelf, hit,
		credits, help, log, test, window, book, sleep, look, vent, crawl, dining, room, psych, leave,
		check, desk, login, computer, add, record, database, update, delete, records
	}
	
    @Override
    public String toString() {
    	
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
	 * perform method will get the words from user's input
	 * 
	 * @param message
	 */
	public void perform(String message)
	{
		/*This will be added to and abstract base class for all scenes soon but this was patched in by Trenton to Coles Scene code for better CLI functionality*/
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
