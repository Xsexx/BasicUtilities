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
	public String GetText(Object property, Object... args)
	{
		StringBuilder data = new StringBuilder();
		List<Object> propertiesList = Arrays.asList(new Object[] {Text.week_news});

		// In case the property need to get a list.
		if(propertiesList.contains(property))
		{
			data.append(GetTextFromList(GetStringList(property)));
		}
		else
		{
			data.append(White(GetString(property)));
		}
		
		return args.length != 0 ? GetTextFormatByArgs(data, args) : data.toString();
	}

	/**
	 * Method that handles the args list when get text.
	 * @param list
	 * @return
	 */
	private String GetTextFormatByArgs(StringBuilder data, Object... args)
	{
		for (Object string : args)
		{
			this.utils.SendConsoleMessage(string.toString());
		}

		return String.format(data.toString(), args);
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
}
