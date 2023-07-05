package BusinessLogic;

import Base.Base;
import Main.BasicUtilities;

public class ConfigBL extends Base {

     /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public ConfigBL(BasicUtilities objBasicUtilities)
    {
		this.basicUtilities = objBasicUtilities;
        this.config = this.basicUtilities.configManager.GetFile(FileConfigurationName.config);
	}

    public Boolean GetWelcomeMessageIsEnable()
    {
        try
        {
            return this.config.getBoolean("Config.welcome-message");
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
            return false;
        }
    }

    /**
     * Method that handles the asignation of the spawns point by availability.
     * @param playerCount
     * @return The spawn point available.
     */
    public String GetAvailableSpawnPoint(int playerCount)
    {
        int spawnPointCount = this.config.getInt("Config.spawn-points.spawn-point-count", playerCount);

        try
        {
            // Find a available spawn point.
            for(int i = 1; i < spawnPointCount; i++)
            {
                if(!this.config.getBoolean(String.format("Config.spawn-points.spawn-point-%s.asigned", i)))
                {
                    return String.format("Config.spawn-points.spawn-point-%s", i);
                }
            }
        }
        catch(Exception exc)
        {
            ExceptionManager(exc);
        }

        // In case each spawn point is busy, asign the next-one by countplater
        return String.format("Config.spawn-points.spawn-point-%s", playerCount % spawnPointCount);
    }
    
}
