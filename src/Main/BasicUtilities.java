package main;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import businessLogic.TextBL;
import businessLogic.UtilsBL;
import commands.CommandLocation;
import commands.CommandUtils;
import configuration.ConfigManager;
import listeners.PlayerLogin;

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
		objPluginManager.registerEvents(new PlayerLogin(this), this);
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
