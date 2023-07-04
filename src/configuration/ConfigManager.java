package configuration;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import main.BasicUtilities;

public class ConfigManager
{
    private BasicUtilities basicUtilities;
    
    // Config files
    private FileConfiguration ConfigCfg;
    private File ConfigFile;

    private FileConfiguration PlayerCfg;
    private File PlayerFile;

    private FileConfiguration TextCfg;
    private File TextFile;

    /**
     * Constructor
     * @param objBasicUtilities
     */
    public ConfigManager(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
    }

    /**
     * Method that centralize the config files per type.
     * @param fileName
     * @return
     */
    private FileConfiguration GetConfigFileByType(String fileName)
    {
        switch(fileName)
        {
            case "config":
                return ConfigCfg;
            case "player":
                return PlayerCfg;
            case "text":
                return TextCfg;
            default:
                return null;
        }
    }

    /**
     * Method that centralize the files per type.
     * @param fileName
     * @return
     */
    private File GetFileByType(String fileName)
    {
        switch(fileName)
        {
            case "config":
                return ConfigFile;
            case "player":
                return PlayerFile;
            case "text":
                return TextFile;
            default:
                return null;
        }
    }

    /**
     * Method that register the file like config files.
     * @param fileName
     */
    public void RegisterFile(String fileName)
    {
        // Files by name.
        FileConfiguration config = GetConfigFileByType(fileName);
        File file = GetFileByType(fileName);
        fileName = String.format("%s.%s", fileName, "yml");

        file = new File(basicUtilities.getDataFolder(), fileName);
        
        if(!file.exists())
        {
            GetFile(config, file, fileName).options().copyDefaults(true);
            SaveFile(config, file, fileName);
        }
    }

    /**
     * Method to get the files.
     * @param fileName
     * @return File by type.
     */
    public FileConfiguration GetFile(String fileName)
    {
        return GetFile(GetConfigFileByType(fileName), GetFileByType(fileName), String.format("%s.%s", fileName, "yml"));
    }

    /**
     * Method to get the files (Overload).
     * @param config
     * @param file
     * @param fileName
     * @return File by type.
     */
    public FileConfiguration GetFile(FileConfiguration config, File file, String fileName)
    {
        if(config == null)
        {
            ReloadFile(config, file, fileName);
        }

        return config;
    }

    /**
     * Method that save the data file.
     * @param config
     * @param file
     * @param fileName
    */
    public void SaveFile(FileConfiguration config, File file, String fileName)
    {
        try
        {
            config.save(file);
        }
        catch (Exception exc)
        {
            basicUtilities.utils.SendConsoleMessage(exc.getMessage());
        }
    }

    /**
     * Method that reload the files config.
     * @param fileName
     */
    public void ReloadFile(String fileName)
    {
        // Files by name.
        ReloadFile(GetConfigFileByType(fileName), GetFileByType(fileName), String.format("%s.%s", fileName, "yml"));
    }

    /**
     * Method that reload the files config (Overload).
     * @param config
     * @param file
     * @param fileName
     */
    public void ReloadFile(FileConfiguration config, File file, String fileName)
    {
        try
        {
            // In case that file was null, create a new file.
            if(config == null)
            {
                file = new File(basicUtilities.getDataFolder(), fileName);
            }

            config = YamlConfiguration.loadConfiguration(file);
            Reader defConfigString = new InputStreamReader(basicUtilities.getResource(fileName), "UTF8");

            if(defConfigString != null)
            {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigString);
                config.setDefaults(defConfig);
            }
        }
        catch (Exception exc)
        {
            basicUtilities.utils.SendConsoleMessage(exc.getMessage());
        }
    }
}
