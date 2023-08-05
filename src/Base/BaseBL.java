package Base;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import Main.BasicUtilities;

/**
 * Super class that handles the general attributes for business logic.
 */
public class BaseBL extends Base
{
    //region VARIABLES
    
    private StringBuilder base = new StringBuilder();  
    private FileConfiguration fileConfiguration;

    //endregion

    //region METHODS

    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public BaseBL(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
    }

    /**
     * Constructor
     * @param objBasicUtilities
     * @param file
     */
    public BaseBL(BasicUtilities objBasicUtilities, FileName file)
    {
        super(objBasicUtilities);
        this.fileConfiguration = FileMananger().GetFile(file);
    }

    /**
     * Constructor
     * @param objBasicUtilities
     * @param file
     */
    public BaseBL(BasicUtilities objBasicUtilities, FileName file, String base)
    {
        super(objBasicUtilities);
        this.fileConfiguration = FileMananger().GetFile(file);
        this.base.append(base);
    }

    //region PROPERTIES
    
    /**
     * Method that handles the file properties build.
     * @param args
     * @return String
     */
    private String GetStringFromProperties(Object... properties)
    {
        StringBuilder result = new StringBuilder();

        if(!this.base.isEmpty())
        {
            result.append(this.base);
        }

        // It include all properties includes in the params.
        for (Object property : properties)
        {
            if(result.isEmpty())
            {
                result.append(String.format("%s", property.toString()));
            }
            else
            {
                result.append(String.format(".%s", property.toString()));
            }
        }

        return result.toString();
    }

    /**
     * Method that handles the new enums.
     * @param property
     * @param data
     * @return
     */
    public General GetProperty(General property, Object data)
    {
        return General.valueOf(String.format("%s_%s", property.toString(), data));
    }

    //endregion

    //region GETTERS

    /**
     * Method that handles getting data from config files.
     * @param base
     * @return String data.
     */
    protected String GetString(Object... properties)
    {
        return this.fileConfiguration.getString(GetStringFromProperties(properties));
    }

    /**
     * Method that handles getting data from config files.
     * @param base
     * @return String data.
     */
    protected List<String> GetStringList(Object... properties)
    {
        return this.fileConfiguration.getStringList(GetStringFromProperties(properties));
    }

    /**
     * Method that handles getting data from config files.
     * @param base
     * @return Boolean data.
     */
    protected Boolean GetBoolean(Object... properties)
    {
        return this.fileConfiguration.getBoolean(GetStringFromProperties(properties));
    }

    /**
     * Method that handles getting data from config files.
     * @param base
     * @return Int data.
     */
    protected int GetInt(Object... properties)
    {
        return this.fileConfiguration.getInt(GetStringFromProperties(properties));
    }

    /**
     * Method that handles getting data from config files.
     * @param base
     * @return Double data.
     */
    protected double GetDouble(Object... properties)
    {
        return this.fileConfiguration.getDouble(GetStringFromProperties(properties));
    }

    /**
     * Method that handles get the file config.
     * @return
     */
    protected FileConfiguration FileConfiguration()
    {
        return this.fileConfiguration;
    }

    //endregion

    //region SETTERS

    /**
     * Method that handles setting data into config files.
     * @param data
     * @param properties
     */
    protected void Set(String data, Object... properties)
    {
        this.fileConfiguration.set(GetStringFromProperties(properties), data);
    }

    /**
     * Overload.
     * @param data
     * @param properties
     */
    protected void Set(List<String> data, Object... properties)
    {
        this.fileConfiguration.set(GetStringFromProperties(properties), data);
    }

    /**
     * Overload.
     * @param data
     * @param properties
     */
    protected void Set(int data, Object... properties)
    {
        this.fileConfiguration.set(GetStringFromProperties(properties), data);
    }

    /**
     * Overload.
     * @param data
     * @param properties
     */
    protected void Set(Boolean data, Object... properties)
    {
        this.fileConfiguration.set(GetStringFromProperties(properties), data);
    }

    /**
     * Overload.
     * @param data
     * @param properties
     */
    protected void Set(double data, Object... properties)
    {
        this.fileConfiguration.set(GetStringFromProperties(properties), data);
    }

    /**
     * Method that handles set the file config.
     * @return
     */
    protected void FileConfiguration(FileConfiguration fileConfiguration)
    {
        this.fileConfiguration = fileConfiguration;
    }

    //endregion

    //region COLORS

    /**
	 * Method that handles text color.
	 * @param text
	 * @param color
	 * @return
	 */
	private String TextColor(String text, ChatColor color)
	{
		return String.format("%s%s%s", color, text, ChatColor.WHITE);
	}

    /**
	 * Method that handles text color white.
	 * @param text
	 * @param color
	 * @return
	 */
	public String White(String text)
	{
		return TextColor(text, ChatColor.WHITE);
	}

    /**
	 * Method that handles text color yellow.
	 * @param text
	 * @param color
	 * @return
	 */
	public String Yellow(String text)
	{
		return TextColor(text, ChatColor.YELLOW);
	}

    /**
	 * Method that handles text color red.
	 * @param text
	 * @param color
	 * @return
	 */
	public String Red(String text)
	{
		return TextColor(text, ChatColor.RED);
	}

    /**
     * Method that handles text color blue.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String Blue(String text)
    {
        return TextColor(text, ChatColor.BLUE);
    }

    /**
     * Method that handles text color green.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String Green(String text)
    {
        return TextColor(text, ChatColor.GREEN);
    }

    /**
     * Method that handles text color light purple.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String LightPurple(String text)
    {
        return TextColor(text, ChatColor.LIGHT_PURPLE);
    }

    /**
     * Method that handles text color gray.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String Gray(String text)
    {
        return TextColor(text, ChatColor.GRAY);
    }

    /**
     * Method that handles text color gold.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String Gold(String text)
    {
        return TextColor(text, ChatColor.GOLD);
    }

    /**
     * Method that handles text color dark red.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String DarkRed(String text)
    {
        return TextColor(text, ChatColor.DARK_RED);
    }

    /**
     * Method that handles text color dark blue.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String DarkBlue(String text)
    {
        return TextColor(text, ChatColor.DARK_BLUE);
    }

    /**
     * Method that handles text color dark green.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String DarkGreen(String text)
    {
        return TextColor(text, ChatColor.DARK_GREEN);
    }

    /**
     * Method that handles text color dark purple.
     * @param text The text to be colored.
     * @return The colored text.
     */
    public String DarkPurple(String text)
    {
        return TextColor(text, ChatColor.DARK_PURPLE);
    }

    //endregion

    //endregion

}