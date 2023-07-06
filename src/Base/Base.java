package Base;

import Main.BasicUtilities;

/**
 * Super class that handles the general attributes.
 */
public class Base
{
    /**
     * Stardard method that handles the exceptions.
     * @param exc
     */
    protected void ExceptionManager(Exception exc)
    {
        this.basicUtilities.utils.SendConsoleMessage(exc.getMessage());
    }

    //region VARIABLES.
    protected BasicUtilities basicUtilities;
    //endregion
}
