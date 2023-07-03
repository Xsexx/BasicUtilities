package Main;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import BusinessLogic.TextBL;
import BusinessLogic.UtilsBL;
import Commands.CommandAddLocation;
import Commands.CommandUtils;
import DataAccess.ConfigDA;
import Listeners.PlayerLogin;

public class BasicUtilities extends JavaPlugin
{
	public UtilsBL utils;
	public PluginDescriptionFile pdfFile;
	public String rutaConfig;
	
	/**
	 * Console test.
	 *  
	 * 
	public static void main(String[] args)
	{
		System.out.println();
		System.out.println();
	}
     */

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
		this.getCommand("location").setExecutor(new CommandAddLocation(this));
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
		new ConfigDA(this);
	}
}
