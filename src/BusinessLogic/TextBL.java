package BusinessLogic;

import java.util.Arrays;
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
	 * @param property
	 * @return
	 */
	public String GetText(Properties property, String... args)
	{
		StringBuilder data = new StringBuilder();
		List<Properties> propertiesList = Arrays.asList(new Properties[] {Properties.week_news});

		// In case the property need to get a list.
		if(propertiesList.contains(property))
		{
			data.append(White(GetTextFromList(GetStringList(property))));
		}
		else
		{
			data.append(White(GetString(property)));
		}

		String result = data.toString();

		for (String string : args)
		{
			result = String.format(result, string);
		}

		return result;
	}

	/**
	 * Method that handles the list from text files.
	 * @param list
	 * @return
	 */
	private String GetTextFromList(List<String> list)
	{
		StringBuilder result = new StringBuilder();

		for (String string : list)
		{
			result.append(White(string));
			result.append(System.lineSeparator());
		}

		return result.toString();
	}

	/**
	 * Method that hanldes build the format for the start message.
	 */
	public String GetPluginReloadText()
	{
		return White(GetString(Properties.plugin_reload_text));
	}
}
