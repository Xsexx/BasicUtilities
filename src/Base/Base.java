package Base;

import BusinessLogic.UtilsBL;
import Main.BasicUtilities;

/**
 * Super class that handles the general attributes.
 */
public class Base
{
    //region VARIABLES.
    protected BasicUtilities basicUtilities;
    protected UtilsBL utils;
    //endregion

    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public Base(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
        this.utils = new UtilsBL();
    }

    //region ENUMS

    public enum Properties
    {
        // config
        welcome_message_available,

        // aditional data
        color,
        asigned,
        count,
        name,
        rank_id,

        // spawn point
        spawn_point,

        // location
        x,
        y,
        z,
        world,
        yaw,
        pitch,

        // Text
        server_name,
        welcome_message_text,
        plugin_reload_text,
        week_news,
        death_phrases_list_text,
        command_from_console_text,

        // Player

        // Farm missions
        f_,
        f_01,
        f_02,
        f_03,
        f_04,
        f_05,
        f_06,
        f_07,

        // Ranking
        novice,
        beginner,
        intermediate,
        advanced,
        expert,
        master,
        legend,
        mythical,
        god
    }

    //endregion

    /**
     * Stardard method that handles the exceptions.
     * @param exc
     */
    protected void ExceptionManager(Exception exc)
    {
        this.utils.SendConsoleMessage(exc.getMessage());
    }
}
