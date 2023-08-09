package Commands;

import java.util.Arrays;

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

            // For the aditional parameters.
            if(args.length != 0 && Utils.valueOf(args[0]) != null)
            {
                // In case that player send the command.
                if(sender instanceof Player)
                {
                    Player player = (Player) sender;
                    switch (Location.valueOf(args[0]))
                    {
                        case add:
                            /*
                            Location location = player.getLocation();
                            double x = location.getX();
                            double y = location.getY();
                            double z = location.getZ();
                            String world = location.getWorld().getName();
                            float yaw = location.getYaw();
                            float pitch = location.getPitch();
                            */
                            SendPlayerMessage(player, label);
                            break;
                        case view:
                        case delete:
                        case sethome:
                        case deletehome:
                        case tp:
                        case tpr:
                        default:
                            SendPlayerMessage(player, label);
                            break;
                    }
                    
                }
                // In case that console send the command.
                else
                {
                    SendConsoleMessage(Text().GetText(Text.command_from_console_text, BasicUtilities().pdfFile.getName()));
                }
            }
            else
            {
                SendMessage(sender, Arrays.asList(Location.values()).toString());
            }

            // In case that player send the command.
            if(sender instanceof Player)
            {
                // For the aditional parameters.
                if(args.length != 0 && Location.valueOf(args[0]) != null)
                {
                    
                        
                }
            }
            // In case that console send the command.
            else
            {
                SendConsoleMessage(Text().GetText(Text.command_from_console_text, BasicUtilities().pdfFile.getName()));
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return true;
    }
}
