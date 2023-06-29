package Entities;

// Here are located all the strings.
public class Templates
{
	private String StartEndText = "%s[%s%s%s]%s Has been %s (version: %s%s%s)";
	
	private String CommandFromConsole = "%s[%s%s%s]%sThis command cannot be executed from console.";

	private String PluginTemplate = "";

	/**
	 * Method that build the format for the start message.
	 */
	public String GetStartEndTemplate(String name, String version, Boolean flag)
	{
		Color objColor = new Color();
		return String.format(StartEndText, objColor.Red, objColor.White, name, objColor.Red, objColor.White, flag ? "activated" : "disabled", objColor.Blue, version, objColor.White);
	}

	/**
	 * Method that build the format for the start message.
	 */
	public String GetConsoleCommandTemplate(String name, String version)
	{
		Color objColor = new Color();
		return String.format(CommandFromConsole, objColor.Red, objColor.White, name, objColor.Red, objColor.White);
	}

	/**
	 * Method that build the format for the start message.
	 */
	public String GetPluginReloadTemplate(String name, String version)
	{
		return String.format(PluginTemplate);
	}
}
