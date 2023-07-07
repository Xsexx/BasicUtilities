package Base;

import java.io.File;
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
    protected FileConfiguration config;
    protected File file;
    //endregion

    //region ENUMS

    public enum FileName
    {
        config,
        player,
        text,
        item,
        mission,
        mobs,
        log,
        stats,

    }

    public enum Properties
    {
        // config
        welcome_message_available,

        // aditional data
        color,
        asigned,
        count,
        name,
        rank_id,


        // spawn point
        spawn_point,

        // location
        x,
        y,
        z,
        world,
        yaw,
        pitch,

        // Text
        server_name,
        welcome_message_text,
        plugin_reload_text,
        week_news,
        death_phrases_list_text,
        command_from_console_text,
        // Player

        // Farm missions
        f_01,
        f_02,
        f_03,
        f_04,
        f_05,
        f_06,
        f_07,

        // Ranking
        novice,
        beginner,
        intermediate,
        advanced,
        expert,
        master,
        legend,
        mythical,
        god
    }

    //endregion

    //region PROPERTIES

    /**
     * Method that handles the file properties build.
     * @param args
     * @return String
     */
    private String GetProperty(Properties... properties)
    {
        StringBuilder result = new StringBuilder();
        
        // It include all properties includes in the params.
        for (Properties fileProperty : properties)
        {
            if(result.isEmpty())
            {
                result.append(String.format("%s", fileProperty.toString()));
            }
            else
            {
                result.append(String.format(".%s", fileProperty.toString()));
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
    public Properties NewProperty(Properties property, String data)
    {
        return Properties.valueOf(String.format("%s_%s", property.toString(), data));
    }

    /**
     * Overload.
     * @param property
     * @param data
     * @return
     */
    public Properties NewProperty(Properties property, int data)
    {
        return Properties.valueOf(String.format("%s_%d", property.toString(), data));
    }

    /**
     * Overload.
     * @param data1
     * @param data2
     * @return
     */
    public Properties NewProperty(String data1, String data2)
    {
        return Properties.valueOf(String.format("%s_%s", data1, data2));
    }

    //endregion

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
        this.config = this.basicUtilities.configManager.GetFile(file);
    }

    //region GETTERS

    /**
     * Method that handles getting data from config files.
     * @param property
     * @return String data.
     */
    protected String GetString(Properties... properties)
    {
        return this.config.getString(GetProperty(properties));
    }

    /**
     * Method that handles getting data from config files.
     * @param property
     * @return String data.
     */
    protected List<String> GetStringList(Properties... properties)
    {
        return this.config.getStringList(GetProperty(properties));
    }

    /**
     * Method that handles getting data from config files.
     * @param property
     * @return Boolean data.
     */
    protected Boolean GetBoolean(Properties... properties)
    {
        return this.config.getBoolean(GetProperty(properties));
    }

    /**
     * Method that handles getting data from config files.
     * @param property
     * @return Int data.
     */
    protected int GetInt(Properties... properties)
    {
        return this.config.getInt(GetProperty(properties));
    }

    /**
     * Method that handles getting data from config files.
     * @param property
     * @return Double data.
     */
    protected double GetDouble(Properties... properties)
    {
        return this.config.getDouble(GetProperty(properties));
    }

    //endregion

    //region SETTERS

    /**
     * Method that handles setting data into config files.
     * @param data
     * @param properties
     */
    protected void Set(String data, Properties... properties)
    {
        this.config.set(GetProperty(properties), data);
    }

    /**
     * Overload.
     * @param data
     * @param properties
     */
    protected void Set(List<String> data, Properties... properties)
    {
        this.config.set(GetProperty(properties), data);
    }

    /**
     * Overload.
     * @param data
     * @param properties
     */
    protected void Set(int data, Properties... properties)
    {
        this.config.set(GetProperty(properties), data);
    }

    /**
     * Overload.
     * @param data
     * @param properties
     */
    protected void Set(Boolean data, Properties... properties)
    {
        this.config.set(GetProperty(properties), data);
    }

    /**
     * Overload.
     * @param data
     * @param properties
     */
    protected void Set(double data, Properties... properties)
    {
        this.config.set(GetProperty(properties), data);
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
}
