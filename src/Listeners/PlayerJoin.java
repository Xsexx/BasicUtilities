package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import Base.BaseMC;
import BusinessLogic.ConfigBL;
import BusinessLogic.PlayerBL;
import Main.BasicUtilities;

/**
 * Class that handles the player join event.
 */
public class PlayerJoin extends BaseMC implements Listener
{
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public PlayerJoin(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
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
            // Get 
            Player playerMC = event.getPlayer();

            // Ignore all the admin players.
            // if(!objPlayer.isOp())
            {
                // BL objects.
                ConfigBL configBL = new ConfigBL(BasicUtilities());
                PlayerBL playerBL = new PlayerBL(BasicUtilities(), playerMC);
                
                if(!playerBL.PlayerExist())
                {
                    configBL.PlayerCountIncrease();
                }

                // 
                playerBL.CreateOrSetPlayer(playerMC);
                playerBL.AddPlayerEffects();

                // In some cases, the welcome message can be disabled.
                if(configBL.ShowWelcomeMessage())
                {
                    SendPlayerMessage(playerMC,Text().GetText(Text.welcome_message_text, Text().GetText(Text.server_name), playerMC.getName()));
                }

                if(configBL.ShowWeekNews())
                {
                    SendPlayerMessage(playerMC, Text().GetText(Text.week_news));
                }
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }
}
