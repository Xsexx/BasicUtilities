package Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import Base.Base;
import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class PlayerLogin extends Base implements Listener
{
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public PlayerLogin(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
    }

    /**
     * Method that handle 
     * @param event
     */
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        this.config = basicUtilities.configManager.GetFile("config");
        
        if(this.config.getBoolean("Config.welcome-message"))
        {
            this.templates = new TextBL(basicUtilities);
            
            this.basicUtilities.utils.SendPlayerMessage(player, this.templates.GetWelcomeMessageText(player.getName()));
            this.basicUtilities.utils.SendPlayerMessage(player, this.templates.GetWelcomeMessageNewThisWeekText());
        }
    }
}
