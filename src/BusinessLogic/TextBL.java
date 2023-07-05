package BusinessLogic;

import java.util.List;

import Base.Base;
import Entities.ColorDTO;
import Main.BasicUtilities;

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
        this.config = this.basicUtilities.configManager.GetFile(FileConfigurationName.text);
		this.colors = new ColorDTO();
	}

	/**
	 * Method that handles build the format for the start message.
	 */
	public String GetStartEndText(String name, String version, Boolean flag)
	{
		return String.format(this.config.getString("Text.start-end-text"),
		this.colors.Red, this.colors.White, name, this.colors.Red, this.colors.White, flag ? this.config.getString("Text.start-end-text-activated") : this.config.getString("Text.start-end-text-disabled"), this.colors.Blue, version, this.colors.White);
	}

	/**
	 * Method that handles build the format for the start message.
	 */
	public String GetConsoleCommandText(String name, String version)
	{
		return String.format(this.config.getString("Text.command-console-text"),
		this.colors.Red, this.colors.White, name, this.colors.Red, this.colors.White);
	}

	/**
	 * Method that hanldes build the format for the start message.
	 */
	public String GetPluginReloadText(String name, String version)
	{
		return String.format(this.config.getString("Text.plugin-reload-text"));
	}

	/**
	 * Method that handles build the format for the welcome message.
	 */
	public String GetWelcomeMessageText(String playerName)
	{
		return String.format(this.config.getString("Text.welcome-message-text"),
		this.colors.White, this.colors.Red, this.colors.Blue, playerName);
	}

	/**
	 * Method that handles build the format for the welcome message new this week.
	 */
	public String GetWelcomeMessageNewThisWeekText()
	{
		return String.format(GetMessageFromList(this.config.getStringList("Text.welcome-message-text-new-this-week")));
	}

	/**
	 * Method that handles the list from text files.
	 * @param list
	 * @return
	 */
	private String GetMessageFromList(List<String> list)
	{
		StringBuilder result = new StringBuilder();

		for (String string : list)
		{
			result.append(String.format(string, this.colors.White));
			result.append(System.lineSeparator());
		}

		return result.toString();
	}
}
