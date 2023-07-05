package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Base.Base;
import businessLogic.TextBL;
import main.BasicUtilities;

public class CommandLocation extends Base implements CommandExecutor
{
    /**
     * Constructor
     */
    public CommandLocation(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
        this.templates = new TextBL(objBasicUtilities);
    }

    /**
     * Listerner that handles the command action.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        try
        {
            // Player command
            if(sender instanceof Player)
            {
                // Player player = (Player) sender;

                if(args.length != 0)
                {
                    if(args[0].equalsIgnoreCase("add"))
                    {
                        /*
                        Location location = player.getLocation();
                        double x = location.getX();
                        double y = location.getY();
                        double z = location.getZ();
                        String world = location.getWorld().getName();
                        float yaw = location.getYaw();
                        float pitch = location.getPitch();
                        */
                    }
                }
                // basicUtilities.utils.SendPlayerMessage((Player) sender, label);
            }
            // Console command
            else
            {
                this.basicUtilities.utils.SendConsoleMessage(this.templates.GetConsoleCommandText(this.basicUtilities.pdfFile.getName(), this.basicUtilities.pdfFile.getVersion()));
            }
        }
        catch (Exception exc)
        {
            this.basicUtilities.utils.SendConsoleMessage(exc.getMessage());
        }

        return true;
    }
}
