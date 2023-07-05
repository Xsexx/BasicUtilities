package Main;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import BusinessLogic.TextBL;
import BusinessLogic.UtilsBL;
import Commands.CommandLocation;
import Commands.CommandUtils;
import Configuration.ConfigManager;
import Listeners.PlayerJoin;

public class BasicUtilities extends JavaPlugin
{
	public PluginDescriptionFile pdfFile = getDescription();
	public UtilsBL utils = new UtilsBL();
	public ConfigManager configManager = new ConfigManager(this);
	
	/**
	 * Method that handles when the server starts the plugin.
	 */
	public void onEnable()
	{
		// Method for starts the plugin functionalities.
		ConfigRegister();
		CommandRegister();
		ListenerRegister();

		this.utils.SendConsoleMessage(new TextBL(this).GetStartEndText(pdfFile.getName(), pdfFile.getVersion(), true));
	}

	/**
	 * Method that handles when the server ends the plugin.
	 */
	public void onDisable()
	{
		this.utils.SendConsoleMessage(new TextBL(this).GetStartEndText(pdfFile.getName(), pdfFile.getVersion(), false));
	}

	/**
	 * Method that handles register the commands.
	 */
	public void CommandRegister()
	{
		this.getCommand("utils").setExecutor(new CommandUtils(this));
		this.getCommand("location").setExecutor(new CommandLocation(this));
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
		this.configManager.RegisterFile("config");
		this.configManager.RegisterFile("player");
		this.configManager.RegisterFile("text");
	}
}
