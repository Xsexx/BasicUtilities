package Base;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import businessLogic.TextBL;
import entities.ColorDTO;
import main.BasicUtilities;

/**
 * Super class that handles the class attributes.
 */
public class Base
{
    protected BasicUtilities basicUtilities;
    protected TextBL templates;
    protected FileConfiguration config;
	protected ColorDTO colors;
    protected File file;
}
