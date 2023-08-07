package BusinessLogic;

import Base.BaseBL;
import Main.BasicUtilities;

/**
 * Class that handles the general config.
 */
public class ConfigBL extends BaseBL
{
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public ConfigBL(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities, FileName.config);
    }

    /**
     * Method that handles welcome message availability.
     * @return
     */
    public Boolean ShowWelcomeMessage()
    {
        try
        {
            return GetBoolean(Config.welcome_message_available);
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return true;
    }

    /**
     * Method that handles welcome message availability.
     * @return
     */
    public Boolean ShowWeekNews()
    {
        try
        {
            // Pending
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return true;
    }

    /**
     * Method that handles the asignation of the spawns point by availability.
     * @param playerCount
     * @return The spawn point id available.
     */
    public int GetAvailableSpawnPoint(int playerCount)
    {
        int spawnPointCount = GetInt(Spawn.spawn_point, General.count);

        try
        {
            // Find a available spawn point.
            for(int i = 1; i < spawnPointCount; i++)
            {
                if(!GetBoolean(GetProperty(Spawn.spawn_point, i), General.asigned))
                {
                    return i;
                }
            }
        }
        catch(Exception exc)
        {
            ExceptionManager(exc);
        }

        // In case each spawn point is busy, asign the next-one by countplater
        return playerCount % spawnPointCount;
    }
}
