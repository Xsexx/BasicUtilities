package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Base.BaseMC;
import Main.BasicUtilities;

/**
 * Class that handles the location command.
 */
public class Location extends BaseMC implements CommandExecutor
{
    /**
     * Constructor
     */
    public Location(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
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
                SendConsoleMessage(this.text.GetText(Text.command_from_console_text, BasicUtilities().pdfFile.getName()));
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return true;
    }
}
