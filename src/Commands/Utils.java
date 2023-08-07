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
                SendPlayerMessage((Player) sender, label);
            }
            // In case that console send the command.
            else
            {
                // For the aditional parameters.
                if(args.length != 0 && Utils.valueOf(args[0]) != null)
                {
                    switch (Utils.valueOf(args[0]))
                    {
                        case reload:
                            FileMananger().ReloadFiles();
                            SendConsoleMessage(this.text.GetText(Text.plugin_reload_text, BasicUtilities().pdfFile.getName()));
                            break;
                        case exception:
                            throw new Exception("Pruebas de excepcion guardadas en el log", null);
                        default:
                            break;
                    }
                }
                else
                {
                    SendConsoleMessage(this.text.GetText(Text.command_from_console_text, BasicUtilities().pdfFile.getName()));
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
