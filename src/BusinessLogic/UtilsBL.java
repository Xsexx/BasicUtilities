package BusinessLogic;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UtilsBL
{
	/**
	 * Method that handles send messages to the console.
	 * @param message
	 */
	public void SendConsoleMessage(String message)
	{
		Bukkit.getConsoleSender().sendMessage(message);
	}

	/**
	 * Method that handles send messages to the player.
	 * @param player
	 * @param message
	 */
	public void SendPlayerMessage(Player player, String message)
	{
		player.sendMessage(message);
	}
}
