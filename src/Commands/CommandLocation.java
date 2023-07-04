package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import businessLogic.TextBL;
import main.BasicUtilities;

public class CommandLocation implements CommandExecutor
{

    private BasicUtilities basicUtilities;
    private TextBL templates;

    /**
     * Constructor
     */
    public CommandLocation(BasicUtilities basicUtilities)
    {
        this.basicUtilities = basicUtilities;
        this.templates = new TextBL(basicUtilities);
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
                basicUtilities.utils.SendConsoleMessage(templates.GetStartEndText(basicUtilities.pdfFile.getName(), basicUtilities.pdfFile.getVersion(),false));
            }
        }
        catch (Exception exc)
        {

        }

        return true;
    }
}
