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
    //region VARIABLES

    private File file;

    //endregion

    //region METHODS

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
        return String.format("%s.%s", fileName, "yml");
    }

    /**
     * Method that handles the register for config files.
     * @param fileName
     */
    public void RegisterFiles()
    {
        RegisterFile(FileName.config);
        RegisterFile(FileName.players);
        RegisterFile(FileName.text);
        RegisterFile(FileName.spawn);
        RegisterFile(FileName.mission);
        RegisterFile(FileName.log);
    }
    
    /**
     * Method that handles reload the config files.
     * @param fileName
     */
    public void ReloadFiles()
    {
        try
        {
            ReloadFile(FileName.config, true);
            ReloadFile(FileName.players, true);
            ReloadFile(FileName.text, true);
            ReloadFile(FileName.spawn, true);
            ReloadFile(FileName.mission, true);
            ReloadFile(FileName.log, true);
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
        file = new File(BasicUtilities().getDataFolder(), GetFilePath(fileName));

        if(!file.exists())
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
        if(FileConfiguration(fileName) == null)
        {
            ReloadFile(fileName, false);
        }

        return FileConfiguration(fileName);
    }

    /**
     * Method that handles save the data on config files.
     * @param fileName
    */
    public void SaveFile(FileName fileName)
    {
        try
        {
            FileConfiguration(fileName).save(file);
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
    public void ReloadFile(FileName fileName, boolean fromReload)
    {
        try
        {
            if(fromReload)
            {
                file = new File(BasicUtilities().getDataFolder(), GetFilePath(fileName));
                FileConfiguration(fileName, null);
            }

            // In case that file was null, create a new file.
            FileConfiguration(fileName, YamlConfiguration.loadConfiguration(file));
            Reader defConfigString = new InputStreamReader(BasicUtilities().getResource(GetFilePath(fileName)), "UTF8");

            if(defConfigString != null)
            {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigString);
                FileConfiguration(fileName).setDefaults(defConfig);
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }

    //endregion
}
