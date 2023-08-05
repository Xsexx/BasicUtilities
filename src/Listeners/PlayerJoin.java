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
            Player objPlayer = event.getPlayer();

            // BL objects.
            PlayerBL objPlayerBL = new PlayerBL(BasicUtilities(), objPlayer);
            ConfigBL objConfigBL = new ConfigBL(BasicUtilities());

            // Ignore all the admin players.
            if(!objPlayer.isOp())
            {
                // In case the player do not exist, it will be added to the player config file.
                objPlayerBL.ValidateOrCreatePlayer(objPlayer);

                // In some cases, the welcome message can be disabled.
                if(objConfigBL.ShowWelcomeMessage())
                {
                    SendPlayerMessage(objPlayer, this.text.GetText(Text.welcome_message_text, this.text.GetText(Text.server_name), objPlayer.getName()));
                }

                if(objConfigBL.ShowWeekNews())
                {
                    SendPlayerMessage(objPlayer, this.text.GetText(Text.week_news));
                }
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }
    }
}
