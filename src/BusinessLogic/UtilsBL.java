package BusinessLogic;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import Base.BaseBL;
import Main.BasicUtilities;

public class UtilsBL extends BaseBL
{
	/**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public UtilsBL(BasicUtilities objBasicUtilities)
    {
		this.basicUtilities = objBasicUtilities;
	}

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
