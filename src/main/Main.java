package main;

import logic.Utils;
import entities.Templates;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	private Utils Utils = new Utils();
	private static Templates Templates = new Templates();
	
	/***
	 * Pruebas de consola.
	 */
	public static void main(String[] args)
	{
		// System.out.println(Templates.GetStartEndTemplate("BasicUtilities", "1.0.1",true));
	}
	
	/***
	 * 	Method that is executed when the server read the plugin.
	 */
	public void onEnable()
	{
		PluginDescriptionFile pdfFile = getDescription();
		Utils.SendConsoleMessage(Templates.GetStartEndTemplate(pdfFile.getName(), pdfFile.getVersion(),true));
	}

	/***
	 * 	Method that is executed when the server read the plugin.
	 */
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = getDescription();
		Utils.SendConsoleMessage(Templates.GetStartEndTemplate(pdfFile.getName(), pdfFile.getVersion(),false));
	}

}
