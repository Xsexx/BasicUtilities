package Configuration;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Base.Base;
import Main.BasicUtilities;

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
     * Method that handles the format name by file.
     * @param fileName
     * @return
     */
    private String FormatName(FileConfigurationName fileName)
    {
        return String.format("%s.%s", fileName.toString(), "yml");
    }

    /**
     * Method that handles the register for config files.
     * @param fileName
     */
    public void RegisterFile(FileConfigurationName fileName)
    {
        if(!new File(this.basicUtilities.getDataFolder(), FormatName(fileName)).exists())
        {
            GetFile(fileName).options().copyDefaults(true);
            SaveFile(fileName);
        }
    }

    /**
     * Method that handles get the config files.
     * @param fileName
     * @return File by type.
     */
    public FileConfiguration GetFile(FileConfigurationName fileName)
    {
        ReloadFile(fileName);
        return this.config;
    }

    /**
     * Method that handles save the data on config files.
     * @param fileName
    */
    public void SaveFile(FileConfigurationName fileName)
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
     * Method that handles reload the config files.
     * @param fileName
     */
    public void ReloadFile(FileConfigurationName fileName)
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
