package BusinessLogic;

import org.bukkit.configuration.file.FileConfiguration;

import Entities.ColorDTO;
import Main.BasicUtilities;

// Here are located all the strings.
public class TextBL
{
    private FileConfiguration config;
	private ColorDTO colors = new ColorDTO();
	/**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public TextBL(BasicUtilities objBasicUtilities)
    {
        this.config = objBasicUtilities.getConfig();
	}

	/**
	 * Method that build the format for the start message.
	 */
	public String GetStartEndText(String name, String version, Boolean flag)
	{
		return String.format(config.getString("Templates.start-end-text"), colors.Red, colors.White, name, colors.Red, colors.White, flag ? config.getString("start-end-text-activated") : config.getString("start-end-text-disabled"), colors.Blue, version, colors.White);
	}

	/**
	 * Method that build the format for the start message.
	 */
	public String GetConsoleCommandText(String name, String version)
	{
		return String.format(config.getString("Templates.command-console-text"), colors.Red, colors.White, name, colors.Red, colors.White);
	}

	/**
	 * Method that build the format for the start message.
	 */
	public String GetPluginReloadText(String name, String version)
	{
		return String.format(config.getString("Templates.plugin-reload-text"));
	}

	/**
	 * Method that build the format for the welcome message.
	 */
	public String GetWelcomeMessageText(String playerName)
	{
		return String.format(config.getString("Templates.welcome-message-text"),
		colors.White, colors.Red, colors.Blue, playerName);
	}

	/**
	 * Method that build the format for the welcome message new this week.
	 */
	public String GetWelcomeMessageNewThisWeekText()
	{
		return String.format(config.getString("Templates.welcome-message-text-new-this-week"));
	}
}
