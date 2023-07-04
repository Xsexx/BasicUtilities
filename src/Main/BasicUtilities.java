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
	public UtilsBL utils;
	public PluginDescriptionFile pdfFile;
	public String rutaConfig;
	
	/**
	 * Method to execute when the server read the plugin on the start.
	 */
	public void onEnable()
	{
		// Message to console, with the plugin info.
		utils.SendConsoleMessage(new TextBL(this).GetStartEndText(pdfFile.getName(), pdfFile.getVersion(), true));

		// Method for starts the plugin functionalities.
		CommandRegister();
		EventRegister();
		ConfigRegister();

		this.utils = new UtilsBL();
		this.pdfFile = getDescription();
	}

	/**
	 * Method to execute when the server read the plugin on the end.
	 */
	public void onDisable()
	{
		utils.SendConsoleMessage(new TextBL(this).GetStartEndText(pdfFile.getName(), pdfFile.getVersion(), false));
	}

	/**
	 * Method to register the commands.
	 */
	public void CommandRegister()
	{
		this.getCommand("utils").setExecutor(new CommandUtils(this));
		this.getCommand("location").setExecutor(new CommandLocation(this));
	}

	/**
	 * Method to register the events.
	 */
	public void EventRegister()
	{
		PluginManager objPluginManager = getServer().getPluginManager();
		objPluginManager.registerEvents(new PlayerLogin(this), this);
	}

	/**
	 * Method to create the config files.
	 */
	public void ConfigRegister()
	{
		ConfigManager configManager = new ConfigManager(this);
		configManager.RegisterFile("config");
		configManager.RegisterFile("player");
		configManager.RegisterFile("text");
	}
}
