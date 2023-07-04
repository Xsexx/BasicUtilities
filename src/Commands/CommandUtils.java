package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import businessLogic.TextBL;
import configuration.ConfigManager;
import main.BasicUtilities;

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
            TextBL templates = new TextBL(basicUtilities);

            // Player command
            if(sender instanceof Player)
            {
                basicUtilities.utils.SendPlayerMessage((Player) sender, label);
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
                        ConfigManager configManager = new ConfigManager(basicUtilities);
                        configManager.ReloadFile("config");
                        configManager.ReloadFile("player");
                        configManager.ReloadFile("text");
                        basicUtilities.utils.SendConsoleMessage(templates.GetConsoleCommandText(basicUtilities.pdfFile.getName(), basicUtilities.pdfFile.getVersion()));
                    }
                    else if(args[0].equalsIgnoreCase("another") && args[0].equalsIgnoreCase("function"))
                    {
                        // Not today.
                    }
                }
                else
                {
                    basicUtilities.utils.SendConsoleMessage(templates.GetConsoleCommandText(basicUtilities.pdfFile.getName(), basicUtilities.pdfFile.getVersion()));
                }
            }
        }
        catch (Exception exc)
        {
            basicUtilities.utils.SendConsoleMessage(exc.getMessage());
        }

        return true;
    }
}
