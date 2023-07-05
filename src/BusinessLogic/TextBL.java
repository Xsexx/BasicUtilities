package businessLogic;

import Base.Base;
import entities.ColorDTO;
import main.BasicUtilities;

// Class that handles all the text templates from "text.yml".
public class TextBL extends Base
{
	/**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public TextBL(BasicUtilities objBasicUtilities)
    {
		this.basicUtilities = objBasicUtilities;
        this.config = this.basicUtilities.configManager.GetFile("text");
		this.colors = new ColorDTO();
	}

	/**
	 * Method that handles build the format for the start message.
	 */
	public String GetStartEndText(String name, String version, Boolean flag)
	{
		return String.format(this.config.getString("Templates.start-end-text"),
		this.colors.Red, this.colors.White, name, this.colors.Red, this.colors.White, flag ? this.config.getString("Templates.start-end-text-activated") : this.config.getString("Templates.start-end-text-disabled"), this.colors.Blue, version, this.colors.White);
	}

	/**
	 * Method that handles build the format for the start message.
	 */
	public String GetConsoleCommandText(String name, String version)
	{
		return String.format(this.config.getString("Templates.command-console-text"),
		this.colors.Red, this.colors.White, name, this.colors.Red, this.colors.White);
	}

	/**
	 * Method that hanldes build the format for the start message.
	 */
	public String GetPluginReloadText(String name, String version)
	{
		return String.format(this.config.getString("Templates.plugin-reload-text"));
	}

	/**
	 * Method that handles build the format for the welcome message.
	 */
	public String GetWelcomeMessageText(String playerName)
	{
		return String.format(this.config.getString("Templates.welcome-message-text"),
		this.colors.White, this.colors.Red, this.colors.Blue, playerName);
	}

	/**
	 * Method that handles build the format for the welcome message new this week.
	 */
	public String GetWelcomeMessageNewThisWeekText()
	{
		return String.format(this.config.getString("Templates.welcome-message-text-new-this-week"));
	}
}
