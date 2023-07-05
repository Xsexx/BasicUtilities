package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Base.Base;
import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class PlayerJoin extends Base implements Listener
{
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public PlayerJoin(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
    }

    /**
     * Method that handles the user join to the server.
     * @param event
     */
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        this.config = basicUtilities.configManager.GetFile("config");
        
        // In some cases, the welcome message can be disabled.
        if(this.config.getBoolean("Config.welcome-message"))
        {
            this.templates = new TextBL(basicUtilities);
            
            // Welcome message and week info
            this.basicUtilities.utils.SendPlayerMessage(player, this.templates.GetWelcomeMessageText(player.getName()));
            this.basicUtilities.utils.SendPlayerMessage(player, this.templates.GetWelcomeMessageNewThisWeekText());
        }
    }
}
