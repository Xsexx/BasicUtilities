package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class CommandAddLocation implements CommandExecutor
{

    private BasicUtilities basicUtilities;

    /**
     * Constructor
     */
    public CommandAddLocation(BasicUtilities basicUtilities)
    {
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
                basicUtilities.utils.SendConsoleMessage(templates.GetStartEndText(basicUtilities.pdfFile.getName(), basicUtilities.pdfFile.getVersion(),false));
            }
        }
        catch (Exception exc)
        {

        }

        return true;
    }
}
