package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Entities.PlayerEntitie;
import Main.BasicUtilities;

public class Commands implements CommandExecutor
{

    private BasicUtilities basicUtilities;

    /**
     * Constructor
     */
    public Commands(BasicUtilities basicUtilities)
    {
        this.basicUtilities = basicUtilities;
    }

    /**
     * Listerner to execute the command action.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        try
        {
            // Player command
            if(sender instanceof Player)
            {
                PlayerEntitie player = new PlayerEntitie();
                player.player = (Player) sender;

                basicUtilities.Utils.SendPlayerMessage(player.player, label);
            }
            // Console command
            else
            {
                basicUtilities.Utils.SendConsoleMessage(basicUtilities.Templates.GetStartEndTemplate(basicUtilities.pdfFile.getName(), basicUtilities.pdfFile.getVersion(),false));
            }
        }
        catch (Exception exc)
        {

        }

        return true;
    }
}
