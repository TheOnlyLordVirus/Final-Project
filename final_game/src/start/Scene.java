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
		northwall, north, eastwall, east, southwall, south, westwall, west,
		wall, floor, bed, clock, door, key, open, close, grab, move, inspect, jump, bookshelf, hit,
		credits, help, log, delete, test, window, book, sleep, look
	}
	
    @Override
    public String toString() {
        return String.format("Location: " + LocationName);
    }
	
	@Override
	public String getName() 
	{
		return LocationName;
	}
	
	@Override
	public String getDescription() 
	{
		return LocationDescription;
	}
	
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
				// Now they are all in lower case.
				//spliter[i] = spliter[i].toLowerCase();
			
				
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
					// Debug data.
					System.out.println("DEBUG: String to Enum Parse error!" + Ex.getMessage());
					System.out.println("DEBUG: I do not understand the word: " + spliter[i] + ", removing word and checking combinations.");
					
					// Write to log.
					Logger.addLog("DEBUG: String to Enum Parse error!" + Ex.getMessage());
					Logger.addLog("DEBUG: I do not understand the word: " + spliter[i] + ", removing word and checking combinations.");
				}	
			}
			
			
			
			// Get combination.
			try
			{
				// Try to parse the string to a combination!
				//currentCombination = enumCombination.valueOf(parseToCombination);
				ParseCombination(parseToCombination);
				
				// If it parses preform the combination.
				interaction();
			}
			
			// If this is a failing combination 
			catch (Exception Ex)
			{
				// Debug data.
				System.out.println("DEBUG: String to Enum Parse error! " + Ex.getMessage());
				System.out.println("DEBUG Word Combo: " + parseToCombination);
				
				// Add this to the logs.
				Logger.addLog("DEBUG: String to Enum Parse error! " + Ex.getMessage());
				Logger.addLog("DEBUG Word Combo: " + parseToCombination);
				
				// Print to user.
				Escape_The_Psych_Ward.iPrintLn("I do not understand this combination of words.");
			}
		}
	}
}
