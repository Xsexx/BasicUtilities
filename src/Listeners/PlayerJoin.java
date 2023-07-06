package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import Base.BaseMC;
import BusinessLogic.ConfigBL;
import BusinessLogic.PlayerBL;
import BusinessLogic.TextBL;
import Entities.PlayerDTO;
import Main.BasicUtilities;

public class PlayerJoin extends BaseMC implements Listener
{
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public PlayerJoin(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
        this.templates = new TextBL(basicUtilities);
    }

    /**
     * Method that handles the user join to the server.
     * @param event
     */
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event)
    {
        try
        {
            Player objPlayer = event.getPlayer();

            // BL objects.
            PlayerBL objPlayerBL = new PlayerBL(this.basicUtilities, objPlayer);
            ConfigBL objConfigBL = new ConfigBL(this.basicUtilities);

            // Ignore all the admin player.
            if(!objPlayer.isOp())
            {
                // In case the player do not exist, it will be added to the player config file.
                if(!objPlayerBL.ValidatePlayerExist(objPlayer))
                {
                    PlayerDTO objPlayerDTO = new PlayerDTO();
                    objPlayerDTO.player = objPlayer;
                    objPlayerDTO.spawnPoint = objConfigBL.GetAvailableSpawnPoint(objPlayerBL.GetPlayersCount());
                }
              
                // In some cases, the welcome message can be disabled.
                if(objConfigBL.GetWelcomeMessageIsEnable())
                {
                    
                    
                    // Welcome message and week info
                    this.basicUtilities.utils.SendPlayerMessage(objPlayer, this.templates.GetWelcomeMessageText(objPlayer.getName()));
                    this.basicUtilities.utils.SendPlayerMessage(objPlayer, this.templates.GetWelcomeMessageNewThisWeekText());
                }
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }
}
