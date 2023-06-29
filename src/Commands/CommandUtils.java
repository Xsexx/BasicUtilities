package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Main.BasicUtilities;

public class CommandUtils implements CommandExecutor
{

    private BasicUtilities basicUtilities;

    /**
     * Constructor
     */
    public CommandUtils(BasicUtilities basicUtilities)
    {
        // Ver video 3 para completar desarrollo.
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
                basicUtilities.Utils.SendPlayerMessage((Player) sender, label);
            }
            // Console command
            else
            {
                // For the aditional commands
                if(args.length != 0)
                {
                    // Reload the plugin's config.
                    if(args[0].equalsIgnoreCase("reload"))
                    {
                        this.basicUtilities.reloadConfig();
                        basicUtilities.Utils.SendConsoleMessage(basicUtilities.Templates.GetConsoleCommandTemplate(basicUtilities.pdfFile.getName(), basicUtilities.pdfFile.getVersion()));
                    }
                    else if(args[0].equalsIgnoreCase("another") && args[0].equalsIgnoreCase("function"))
                    {
                        // Not today.
                    }
                }
                else
                {
                    basicUtilities.Utils.SendConsoleMessage(basicUtilities.Templates.GetConsoleCommandTemplate(basicUtilities.pdfFile.getName(), basicUtilities.pdfFile.getVersion()));
                }
            }
        }
        catch (Exception exc)
        {

        }

        return true;
    }
}
