package BusinessLogic;

import org.bukkit.entity.Player;

import Base.BaseBL;
import Entities.PlayerDTO;
import Main.BasicUtilities;

public class PlayerBL extends BaseBL
{
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public PlayerBL(BasicUtilities objBasicUtilities, Player objPlayer)
    {
		this.basicUtilities = objBasicUtilities;
        this.config = this.basicUtilities.configManager.GetFile(FileConfig.Player);
        
        this.BASE.append(String.format("%s.%s-%s", FileConfig.Player.toString(), objPlayer.getName(), objPlayer.getUniqueId().toString()));
	}

    /**
     * Method that handles the validation of the player exist.
     * @param objPlayer
     * @return In case the player already exist, return true.
     */
    public Boolean ValidatePlayerExist(Player objPlayer)
    {
        try
        {
            return this.config.getString(this.BASE.toString()) != null;
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
            return false;
        }
    }

    /**
     * Method that handles the creation of the data by player.
     * @param objPlayerDTO
     */
    public void AddPlayerToConfig(PlayerDTO objPlayerDTO)
    {
        //this.config.set(this.BASE.append(this.SPAWNPOINT).toString(), objPlayerDTO.spawnPoint);
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
            return this.config.getInt("");
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
            return 0;
        }
    }
}
