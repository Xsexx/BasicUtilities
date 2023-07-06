package Base;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import BusinessLogic.TextBL;
import Entities.ColorDTO;
import Main.BasicUtilities;

/**
 * Super class that handles the general attributes.
 */
public class Base
{
    protected BasicUtilities basicUtilities;
    protected TextBL templates;
    protected FileConfiguration config;
	protected ColorDTO colors;
    protected File file;

    public enum FileConfigurationName
    {
        config, player, text
    }

    /**
     * Stardard method that handles the exceptions.
     * @param exc
     */
    protected void ExceptionManager(Exception exc)
    {
        this.basicUtilities.utils.SendConsoleMessage(exc.getMessage());
    }
}
