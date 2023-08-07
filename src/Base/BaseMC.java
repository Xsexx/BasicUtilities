package Base;

import BusinessLogic.TextBL;
import Main.BasicUtilities;

/**
 * Super class that handles the general attributes for minecraft files.
 */
public class BaseMC extends Base
{
    //region VARIABLES

    protected TextBL text;

	//endregion

	//region ENUMS
	
	protected enum Utils
	{
		reload,
		join_armor,
		join_tools,
		exception
	}

	protected enum Location
	{
		add,
		view,
		delete,
		sethome,
		deletehome,
		tp,
		tpr
	}

	protected enum StarterPack
	{
		get,
		update
	}

	protected enum Quest
	{
		vew,
		claim
	}

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
