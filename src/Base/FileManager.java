package Base;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Main.BasicUtilities;

/**
 * Class that handles the config files.
 */
public class FileManager extends BaseBL
{
    /**
     * Constructor
     * @param objBasicUtilities
     */
    public FileManager(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
    }

    /**
     * Method that handles the format name by file.
     * @param fileName
     * @return
     */
    private String FormatName(FileName fileName)
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
    public FileConfiguration GetFile(FileName fileName)
    {
        switch(fileName)
        {
            
        }
        ReloadFile(fileName);
        return this.config;
    }

    /**
     * Method that handles save the data on config files.
     * @param fileName
    */
    public void SaveFile(FileName fileName)
    {
        try
        {
            this.config.save(new File(this.basicUtilities.getDataFolder(), FormatName(fileName)));
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
            this.config = YamlConfiguration.loadConfiguration(new File(this.basicUtilities.getDataFolder(), FormatName(fileName)));
            Reader defConfigString = new InputStreamReader(this.basicUtilities.getResource(FormatName(fileName)), "UTF8");

            if(defConfigString != null)
            {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigString);
                this.config.setDefaults(defConfig);
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }
}
