package start;

/**
 * West Wall Class extends Scene implements SceneInterfacce
 */
public class WestWall extends Scene implements SceneInterface
{	
	public static class words {
		//Hit wall text
		String hitWithHands = "You hit the wall with you bare hands... this does not have much effect.";
		String hitWithSculpture = "You hit the wall hit the wall with the Store Sculpture. \nA (Rusty Key) Falls to the floor... A Key to what?";
		String NoMoreHit = "No need to break the wall more...";
		//inspect wall text
		String inspectwall1 = "You inspect the wall.";
		String inspectwall2 = "To the right of the bookshelf you notice a rusty piece of metal lodged in a crack on the wall.";
		String inspectwall3 = "If only you had something to break the wall with.";
		//method for adding text to printline
		public void PrintWords (String text1) {
			Escape_The_Psych_Ward.iPrintLn(text1);
		}
		
		//overloaded methods for adding text to printline
		public void PrintWords (String text1, String text2, String text3) {
			Escape_The_Psych_Ward.iPrintLn(text1 + "\n" + text2 + "\n" + text3);
			Escape_The_Psych_Ward.iPrintLn(inspectwall1.toString());
		}
	}
	words words = new words();
	
	// Variables
	public Integer sculpture = 0;
	public Integer rustykey = 0;
	Boolean keyonfloor = false;
	Boolean wallbroken = false;
	enumCombination currentCombination;

	// Combinations for user input on this scene.
	public Scene scene;
	enum enumCombination 
	{
		//Actions
		inspectwall, hitwall, inspectfloor, inspectbookshelf, inspectkey,
		//Movements
		movesouthwall, movenorthwall, moveeastwall, movewestwall,
	}

	// The constructor will set the Location Name and Description for each scene.
	WestWall()
	{
		this.LocationName = "West Wall";
		this.LocationDescription = "You are facing the West Wall, You Notice an object wedged in the wall... you may have to break the wall to reach it.";	
	}
	
	/**
	 * ParseCombination method
	 */
	@Override
	public void ParseCombination(String parseToCombination)
	{
		currentCombination = enumCombination.valueOf(parseToCombination);
	}

	/**
	 * Interaction method performs action based on combination given 
	 */
	@Override
	public void interaction() 
	{
		switch(currentCombination)
		{			
			// Change rooms.
			case movenorthwall:
				GameManager.currentLocation = "NorthWall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the North Wall.");
			break;
			
			case moveeastwall:
				GameManager.currentLocation = "EastWall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the East Wall.");
			break;
			
			case movesouthwall:
				GameManager.currentLocation = "SouthWall";
				GameManager.clear();
				Escape_The_Psych_Ward.iPrintLn("You move to the South Wall.");
			break;
				
			case movewestwall:
				Escape_The_Psych_Ward.iPrintLn("You are already at the West Wall!");
			break;
			
			case inspectbookshelf:
				books book1 = new books();
				book1.setBookName("Guardians");
				Escape_The_Psych_Ward.iPrintLn(book1.getBookName());
				sculpture++;
				Escape_The_Psych_Ward.iPrintLn("You search the bookshelf. *Da Da Da Dahh!* You found " + sculpture + "x (Stone Sculpture).");
			break;

			case hitwall:
				if (!wallbroken && sculpture == 0) {
					words.PrintWords(words.hitWithHands);
				}
				else if(!wallbroken && sculpture != 0) {
					wallbroken = true;
					keyonfloor = true;
					words.PrintWords(words.hitWithSculpture);
				}
				else {
					words.PrintWords(words.NoMoreHit);
				}
				break;

			// inspect wall
			case inspectwall:
				words.PrintWords(words.inspectwall1,words.inspectwall2,words.inspectwall3.toString());
				break;
			
			case inspectfloor: 
				if (keyonfloor) 
				{
					rustykey = 1;
					Escape_The_Psych_Ward.iPrintLn("You find a (Rusty Key) o A Key to what? ");
				}
				break;
				
			case inspectkey:
				if (rustykey == 1) 
				{
					Escape_The_Psych_Ward.iPrintLn("While inspecting the key you notice the word \"North Wall\" engraved into it.");
				}
				else 
				{
					Escape_The_Psych_Ward.iPrintLn("You have no key to inspect.");
				}
				break;
				
			// Null?
			default:
				Escape_The_Psych_Ward.iPrintLn("You can't do that.");
				break;
		}
	}

}
