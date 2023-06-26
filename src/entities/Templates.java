package entities;

// Here are located all the strings.
public class Templates
{
	private String StartEndText = "%s[%s%s%s]%s Has been %s (version: %s%s%s)";
	
	// Method that build the format for the start message.
	public String GetStartEndTemplate(String name, String version, Boolean flag)
	{
		Colors Colors = new Colors();
		return String.format(StartEndText, Colors.Red, Colors.White, name, Colors.White, Colors.Red, flag ? "activated" : "disabled", Colors.Blue, version, Colors.White);
	}
}
