package Base;

import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class BaseMC extends Base
{
    //region VARIABLES.

    protected TextBL text;

    //endregion

    //region METHODS
    
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public BaseMC(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
        this.text = new TextBL(BasicUtilities());
    }

        /**
	 * Method that handles send messages to the console.
	 * @param message
	 */
	protected void SendConsoleMessage(String message)
	{
		Utils().SendConsoleMessage(message);
	}

	/**
	 * Method that handles send messages to the player.
	 * @param player
	 * @param message
	 */
	protected void SendPlayerMessage(org.bukkit.entity.Player player, String message)
	{
		Utils().SendPlayerMessage(player, message);
	}


    //endregion
    
}
