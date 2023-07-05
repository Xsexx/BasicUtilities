package configuration;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Base.Base;
import main.BasicUtilities;

public class ConfigManager extends Base
{
    /**
     * Constructor
     * @param objBasicUtilities
     */
    public ConfigManager(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
    }

    /**
     * Method to format the name of file.
     * @param fileName
     * @return
     */
    private String FormatName(String fileName)
    {
        return String.format("%s.%s", fileName, "yml");
    }

    /**
     * Method that register the file like config files.
     * @param fileName
     */
    public void RegisterFile(String fileName)
    {
        if(!new File(this.basicUtilities.getDataFolder(), FormatName(fileName)).exists())
        {
            GetFile(fileName).options().copyDefaults(true);
            SaveFile(fileName);
        }
    }

    /**
     * Method to get the files.
     * @param fileName
     * @return File by type.
     */
    public FileConfiguration GetFile(String fileName)
    {
        this.config = null;
        this.file = null;
        ReloadFile(fileName);

        return this.config;
    }

    /**
     * Method that save the data file.
     * @param fileName
    */
    public void SaveFile(String fileName)
    {
        try
        {
            this.config.save(this.file);
        }
        catch (Exception exc)
        {
            this.basicUtilities.utils.SendConsoleMessage(exc.getMessage());
        }
    }

    /**
     * Method that reload the files config.
     * @param fileName
     */
    public void ReloadFile(String fileName)
    {
        try
        {
            // In case that file was null, create a new file.
            this.file = new File(this.basicUtilities.getDataFolder(), FormatName(fileName));
            this.config = YamlConfiguration.loadConfiguration(this.file);
            Reader defConfigString = new InputStreamReader(this.basicUtilities.getResource(FormatName(fileName)), "UTF8");

            if(defConfigString != null)
            {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigString);
                this.config.setDefaults(defConfig);
            }
        }
        catch (Exception exc)
        {
            this.basicUtilities.utils.SendConsoleMessage(exc.getMessage());
        }
    }
}
