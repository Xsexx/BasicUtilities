package BusinessLogic;

import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import Base.BaseBL;
import Main.BasicUtilities;

public class FileManagerBL extends BaseBL
{
    /**
     * Constructor
     * @param objBasicUtilities
     */
    public FileManagerBL(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
    }

    /**
     * Method that handles the format name by file.
     * @param fileName
     * @return
     */
    private String FormatName(FileConfig fileName)
    {
        return String.format("%s.%s", fileName.toString().toLowerCase(), "yml");
    }

    /**
     * Method that handles the register for config files.
     * @param fileName
     */
    public void RegisterFile(FileConfig fileName)
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
    public FileConfiguration GetFile(FileConfig fileName)
    {
        ReloadFile(fileName);
        return this.config;
    }

    /**
     * Method that handles save the data on config files.
     * @param fileName
    */
    public void SaveFile(FileConfig fileName)
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
    public void ReloadFile(FileConfig fileName)
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
            ExceptionManager(exc);
        }
    }
}
