package listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import businessLogic.TextBL;
import main.BasicUtilities;

public class PlayerLogin implements Listener
{    
    private BasicUtilities basicUtilities;
    
    public PlayerLogin(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        FileConfiguration config = basicUtilities.getConfig();
        
        if(config.getBoolean("Config.welcome-message"))
        {
            TextBL templates = new TextBL(basicUtilities);
            
            basicUtilities.utils.SendPlayerMessage(player, templates.GetWelcomeMessageText(player.getName()));
            basicUtilities.utils.SendPlayerMessage(player, templates.GetWelcomeMessageNewThisWeekText());
        }
    }
}
