package BusinessLogic;

import java.util.List;

import Base.BaseBL;
import Main.BasicUtilities;

/**
 * Class that handles the text config.
 */
public class TextBL extends BaseBL
{
	/**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public TextBL(BasicUtilities objBasicUtilities)
    {
		super(objBasicUtilities, FileName.text);
	}

	/**
	 * Method that handles build the format for the start message.
	 */
	public String GetCommandFromConsoleText(String pluginName)
	{
		return White(String.format(GetString(Properties.command_from_console_text), Yellow(pluginName)));
	}

	/**
	 * Method that hanldes build the format for the start message.
	 */
	public String GetPluginReloadText()
	{
		return White(GetString(Properties.plugin_reload_text));
	}

	/**
	 * Method that handles build the format for the welcome message.
	 */
	public String GetWelcomeMessageText(String playerName)
	{
		return White(String.format(GetString(Properties.welcome_message_text), Red(GetString(Properties.server_name)), CustomColor(playerName, "#555555")));
	}

	/**
	 * Method that handles build the format for the welcome message new this week.
	 */
	public String GetWelcomeMessageNewThisWeekText()
	{
		return String.format(GetMessageFromList(GetStringList(Properties.week_news)));
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
			result.append(White(string));
			result.append(System.lineSeparator());
		}

		return result.toString();
	}
}
