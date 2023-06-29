package Main;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import BusinessLogic.Utils;
import Commands.CommandAddLocation;
import Commands.CommandUtils;
import Entities.Templates;

public class BasicUtilities extends JavaPlugin
{
	public Utils Utils = new Utils();
	public Templates Templates = new Templates();
	public PluginDescriptionFile pdfFile = getDescription();
	
	/**
	 * Console test.
	 */
	public static void main(String[] args)
	{
		// System.out.println(Templates.GetStartEndTemplate("BasicUtilities", "1.0.1",true));
		// System.out.println(Templates.GetStartEndTemplate("BasicUtilities", "1.0.1",false));
	}
	
	/**
	 * 	Method to execute when the server read the plugin on the start.
	 */
	public void onEnable()
	{
		Utils.SendConsoleMessage(Templates.GetStartEndTemplate(pdfFile.getName(), pdfFile.getVersion(),true));
		
		CommandRegister();
	}

	/**
	 * 	Method to execute when the server read the plugin on the end.
	 */
	public void onDisable()
	{
		Utils.SendConsoleMessage(Templates.GetStartEndTemplate(pdfFile.getName(), pdfFile.getVersion(),false));
	}

	/**
	 * Method to register the commands.
	 */
	public void CommandRegister()
	{
		this.getCommand("utils").setExecutor(new CommandUtils(this));
		this.getCommand("addlocation").setExecutor(new CommandAddLocation(this));
	}
}
