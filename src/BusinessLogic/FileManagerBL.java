package BusinessLogic;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Base.BaseBL;
import Main.BasicUtilities;

/**
 * Class that handles the config files.
 */
public class FileManagerBL extends BaseBL
{
    /**
     * Constructor
     * @param objBasicUtilities
     */
    public FileManagerBL(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
    }

    /**
     * Method that handles the format name by file.
     * @param fileName
     * @return
     */
    private String GetFilePath(FileName fileName)
    {
        return String.format("%s.%s", fileName.toString(), "yml");
    }

    /**
     * Method that handles the register for config files.
     * @param fileName
     */
    public void RegisterFiles()
    {
        RegisterFile(FileName.config);
		RegisterFile(FileName.player);
		RegisterFile(FileName.text);
    }
    
    /**
     * Method that handles reload the config files.
     * @param fileName
     */
    public void ReloadFiles()
    {
        try
        {
            ReloadFile(FileName.config);
            ReloadFile(FileName.player);
            ReloadFile(FileName.text);
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }

    /**
     * Method that handles the register for config file.
     * @param fileName
     */
    public void RegisterFile(FileName fileName)
    {
        if(!new File(BasicUtilities().getDataFolder(), GetFilePath(fileName)).exists())
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
    public FileConfiguration GetFile(FileName fileName)
    {
        if(GetFileByName(fileName) == null)
        {
            ReloadFile(fileName);
        }

        return FileConfiguration();
    }

    /**
     * Method that handles save the data on config files.
     * @param fileName
    */
    public void SaveFile(FileName fileName)
    {
        try
        {
            FileConfiguration().save(new File(BasicUtilities().getDataFolder(), GetFilePath(fileName)));
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }

    /**
     * Method that handles reload the config file.
     * @param fileName
     */
    public void ReloadFile(FileName fileName)
    {
        try
        {
            // In case that file was null, create a new file.
            FileConfiguration(YamlConfiguration.loadConfiguration(new File(BasicUtilities().getDataFolder(), GetFilePath(fileName))));
            Reader defConfigString = new InputStreamReader(BasicUtilities().getResource(GetFilePath(fileName)), "UTF8");

            if(defConfigString != null)
            {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigString);
                FileConfiguration().setDefaults(defConfig);
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }

    /**
     * Method that handles return the file configuration from fileName
     * @param fileName
     * @return
     */
    private FileConfiguration GetFileByName(FileName fileName)
    {
        return switch (fileName)
        {
            case config     -> BasicUtilities().config;
            case player     -> BasicUtilities().player;
            case text       -> BasicUtilities().text;
            case item       -> BasicUtilities().item;
            case spawn      -> BasicUtilities().spawn;
            case mission    -> BasicUtilities().mission;
            case log        -> BasicUtilities().log;
            default         -> BasicUtilities().config;
        };
    }
}