package Main;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import BusinessLogic.FileManagerBL;
import BusinessLogic.UtilsBL;
import Commands.Location;
import Commands.Utils;
import Listeners.PlayerJoin;

public class BasicUtilities extends JavaPlugin
{
	public PluginDescriptionFile pdfFile = getDescription();
	public UtilsBL utils = new UtilsBL(this);
	public FileManagerBL configManager = new FileManagerBL(this);
	
	/**
	 * Method that handles when the server starts the plugin.
	 */
	public void onEnable()
	{
		// Method for starts the plugin functionalities.
		ConfigRegister();
		CommandRegister();
		ListenerRegister();
	}

	/**
	 * Method that handles when the server ends the plugin.
	 */
	public void onDisable()
	{
	}

	/**
	 * Method that handles register the commands.
	 */
	public void CommandRegister()
	{
		this.getCommand("utils").setExecutor(new Utils(this));
		this.getCommand("location").setExecutor(new Location(this));
	}

	/**
	 * Method that handles register the events.
	 */
	public void ListenerRegister()
	{
		PluginManager objPluginManager = getServer().getPluginManager();
		objPluginManager.registerEvents(new PlayerJoin(this), this);
	}

	/**
	 * Method that handles create the config files.
	 */
	public void ConfigRegister()
	{
		this.configManager.RegisterFiles();
	}
}
