package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Base.Base;
import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class Location extends Base implements CommandExecutor
{
    /**
     * Constructor
     */
    public Location(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
        this.templates = new TextBL(objBasicUtilities);
    }

    /**
     * Method that handles the command action.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        try
        {
            // In case that player send the command.
            if(sender instanceof Player)
            {
                // For the aditional parameters.
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
            }
            // In case that console send the command.
            else
            {
                this.basicUtilities.utils.SendConsoleMessage(this.templates.GetConsoleCommandText(this.basicUtilities.pdfFile.getName(), this.basicUtilities.pdfFile.getVersion()));
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return true;
    }
}
