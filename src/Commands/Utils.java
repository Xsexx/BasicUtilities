package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Base.BaseMC;
import Main.BasicUtilities;

/**
 * Class that handles the utils command.
 */
public class Utils extends BaseMC implements CommandExecutor
{
    /**
     * Constructor
     */
    public Utils(BasicUtilities objBasicUtilities)
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
                this.basicUtilities.utils.SendPlayerMessage((Player) sender, label);
            }
            // In case that console send the command.
            else
            {
                // For the aditional parameters.
                if(args.length != 0)
                {
                    // Reload the plugin's config.
                    if(args[0].equalsIgnoreCase("reload"))
                    {
                        this.basicUtilities.configManager.ReloadFiles();
                        this.basicUtilities.utils.SendConsoleMessage(this.templates.GetPluginReloadText());
                    }
                    else if(args[0].equalsIgnoreCase("another") && args[0].equalsIgnoreCase("function"))
                    {
                        // Not today.
                    }
                }
                else
                {
                    this.basicUtilities.utils.SendConsoleMessage(this.templates.GetCommandFromConsoleText(this.basicUtilities.pdfFile.getName()));
                }
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return true;
    }
}
