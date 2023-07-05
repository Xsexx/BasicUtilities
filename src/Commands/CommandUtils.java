package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Base.Base;
import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class CommandUtils extends Base implements CommandExecutor
{
    /**
     * Constructor
     */
    public CommandUtils(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
        this.templates = new TextBL(this.basicUtilities);
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
                        this.basicUtilities.configManager.ReloadFile(FileConfigurationName.config);
                        this.basicUtilities.configManager.ReloadFile(FileConfigurationName.player);
                        this.basicUtilities.configManager.ReloadFile(FileConfigurationName.text);
                        this.basicUtilities.utils.SendConsoleMessage(this.templates.GetPluginReloadText(this.basicUtilities.pdfFile.getName(), this.basicUtilities.pdfFile.getVersion()));
                    }
                    else if(args[0].equalsIgnoreCase("another") && args[0].equalsIgnoreCase("function"))
                    {
                        // Not today.
                    }
                }
                else
                {
                    this.basicUtilities.utils.SendConsoleMessage(this.templates.GetConsoleCommandText(this.basicUtilities.pdfFile.getName(), this.basicUtilities.pdfFile.getVersion()));
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
