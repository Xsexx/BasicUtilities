package Commands;

import java.util.Arrays;

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
            // For the aditional parameters.
            if(args.length != 0 && Utils.valueOf(args[0]) != null)
            {
                // In case that player send the command.
                if(sender instanceof Player)
                {
                    Player player = (Player) sender;
                    switch (Utils.valueOf(args[0]))
                        {
                            case join_armor:
                                SendPlayerMessage(player, label);
                                break;
                            case join_tools:
                                SendPlayerMessage(player, label);
                                break;
                            default:
                                SendPlayerMessage(player, Text().GetText(Text.command_from_console_text, BasicUtilities().pdfFile.getName()));
                                break;
                        }
                    
                }
                // In case that console send the command.
                else
                {
                        switch (Utils.valueOf(args[0]))
                        {
                            case reload:
                                FileMananger().ReloadFiles();
                                SendConsoleMessage(Text().GetText(Text.plugin_reload_text, BasicUtilities().pdfFile.getName()));
                                break;
                            default:
                                SendConsoleMessage(Text().GetText(Text.command_from_console_text, BasicUtilities().pdfFile.getName()));
                                break;
                        }
                }
            }
            else
            {
                SendMessage(sender, Arrays.asList(Utils.values()).toString());
            }
        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return true;
    }
}
