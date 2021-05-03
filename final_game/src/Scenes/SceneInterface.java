package Scenes;

public interface SceneInterface 
{
	// Actually needed to use a interface to define ParseCombination(),
	// Since the enumCombination are all going to be unique to a scene you are unable to call the 'enumCombination.valueOf()' method for parsing user data.
	// Makes the code much simpler...
	// - Trenton
	public String getName();
	public String getDescription();
	public void ParseCombination(String s);
	public void interaction();
}
