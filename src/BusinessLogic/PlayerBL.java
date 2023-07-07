package BusinessLogic;

import org.bukkit.entity.Player;

import Base.BaseBL;
import Entities.PlayerDTO;
import Main.BasicUtilities;

/**
 * Class that handles the player config.
 */
public class PlayerBL extends BaseBL
{
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public PlayerBL(BasicUtilities objBasicUtilities, Player objPlayer)
    {
        super(objBasicUtilities, FileName.player);
    }

    /**
     * Method that handles the validation of the player exist.
     * @param objPlayer
     * @return In case the player already exist, return true.
     */
    public void ValidateOrCreatePlayer(Player player)
    {
        try
        {
            // PlayerDTO playerDTO = new PlayerDTO();
            // playerDTO.Id = NewProperty(player.getName(), player.getUniqueId().toString());
            
            // if(!PlayerExist(playerDTO.Id))
            // {

            //     Set(GetPlayersCount(), Properties.count);
            //     // Falta guardar el archivo.
            // }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }

    /**
     * Method that handles the validation of the player exist.
     * @param objPlayer
     * @return In case the player already exist, return true.
     */
    public Boolean PlayerExist(Properties property)
    {
        try
        {
            return GetBoolean(property) != null;
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return false;
    }

    /**
     * Method that handles get all the data config by player.
     * @param objPlayer
     * @return
     */
    public PlayerDTO GetPlayerData(Player objPlayer)
    {
        PlayerDTO objPlayerDTO = new PlayerDTO();

        try
        {
            objPlayerDTO.player = objPlayer;
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
        
        return objPlayerDTO;
    }

    /**
     * Method that handles the count of players.
     * @return
     */
    public int GetPlayersCount()
    {
        try
        {
            return GetInt(Properties.count);
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
            return 0;
        }
    }
}
