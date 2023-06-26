package logic;

import org.bukkit.Bukkit;

public class Utils
{
	/// Method for send messages to the console.
	public void SendConsoleMessage(String message)
	{
		Bukkit.getConsoleSender().sendMessage(message);
	}
}
