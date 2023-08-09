package BusinessLogic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import Base.BaseBL;
import Entities.PlayerDTO;
import Main.BasicUtilities;

/**
 * Class that handles the player config.
 */
public class PlayerBL extends BaseBL
{
    //region VARIABLES

    PlayerDTO playerDTO = new PlayerDTO();

    //endregion

    //region METHODS

    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public PlayerBL(BasicUtilities objBasicUtilities, Player objPlayerMC)
    {
        super(objBasicUtilities, FileName.players, String.format("%s_%s", objPlayerMC.getName(), objPlayerMC.getUniqueId().toString()));
    }

    /**
     * Method that handles if the player exist.
     * @return
     */
    public Boolean PlayerExist()
    {
        try
        {
            return GetBoolean(GetBase()) != null;
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return false;
    }

    /**
     * Method that handles the validation or creation of the player on config files.
     * @param playerDTO
     */
    public void CreateOrSetPlayer(Player playerMC)
    {
        try
        {
            if(!PlayerExist())
            {
                playerDTO.Id = GetBase();
                playerDTO.Name = playerMC.getName();
                playerDTO.LastConection = LocalDateTime.now();
                playerDTO.PlayerMC = playerMC;
                UpdatePlayerRank(Ranking.novice);
                
                SetPlayerData();
                SaveFile();
            }
            else
            {
                GetPlayer();
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }

    /**
     * Method that handles get player's data.
     * @param objPlayer
     * @return
     */
    private PlayerDTO GetPlayer()
    {
        return this.playerDTO;
    }

    /**
     * Method that handles to set the player data.
     * @return
     */
    private void SetPlayerData()
    {
        Set(playerDTO.Id, General.id);
        Set(playerDTO.Name, General.name);
        Set(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(playerDTO.LastConection), Players.last_conection);
        UpdatePlayerRank(playerDTO.Rank.Rank);
    }

    /**
     * Method that handles the players effects by ranking.
     */
    public void AddPlayerEffects()
    {
        if(playerDTO.Rank.Rank != null)
        {
            playerDTO.PlayerMC.addPotionEffect(new PotionEffect(playerDTO.Rank.Effect, playerDTO.Rank.Duration, playerDTO.Rank.Level));
        }
    }

    /**
     * Method that handles the player rank updates.
     * @return
     */
    public void UpdatePlayerRank(Ranking rank)
    {
        RankBL rankBL = new RankBL(BasicUtilities());
        playerDTO.Rank = rankBL.GetRank(rank);
        Set(playerDTO.Rank.Id, General.rank, General.id);
    }
    
    //endregion
}
