package Base;

import BusinessLogic.FileManagerBL;
import BusinessLogic.LogBL;
import BusinessLogic.UtilsBL;
import Main.BasicUtilities;

/**
 * Super class that handles the general attributes.
 */
public class Base
{
    //region VARIABLES.

    private BasicUtilities basicUtilities;
	private UtilsBL utils;

    //endregion

    //region ENUMS

    public enum Config
    {
        welcome_message_available,
        
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

    public enum Players
    {

    }

    public enum Text
    {
        server_name,
        welcome_message_text,
        plugin_reload_text,
        week_news,
        death_phrases_list_text,
        command_from_console_text
    }

    public enum Spawn
    {
        spawn_point,
        x,
        y,
        z,
        world,
        yaw,
        pitch
    }

    public enum Mission
    {
        //region Mining missions

        m_01,
        m_02,
        m_03,
        m_04,
        m_05,
        m_06,
        m_07,
        m_08,
        
        m_11,
        m_12,
        m_13,
        m_14,
        m_15,
        m_16,

        m_21,
        m_22,
        m_23,
        m_24,

        m_31,
        m_32,
        m_33,

        m_41,
        m_42,

        m_51,
        m_52,

        m_61,

        m_71,

        //endregion

        //region Farm missions

        f_01,
        f_02,
        f_03,
        f_04,
        f_05,
        f_06,
        f_07,
        f_08,
        
        f_11,
        f_12,
        f_13,
        f_14,
        f_15,
        f_16,

        f_21,
        f_22,
        f_23,
        f_24,

        f_31,
        f_32,
        f_33,

        f_41,
        f_42,

        f_51,
        f_52,

        f_61,

        f_71,

        //endregion

        //region Extermination missions
        
        e_01,
        e_02,
        e_03,
        e_04,
        e_05,
        e_06,
        e_07,
        e_08,
        
        e_11,
        e_12,
        e_13,
        e_14,
        e_15,
        e_16,

        e_21,
        e_22,
        e_23,
        e_24,

        e_31,
        e_32,
        e_33,

        e_41,
        e_42,

        e_51,
        e_52,

        e_61,

        e_71,

        //endregion
        
    }
    
    public enum Log
    {
        log,
    }

    public enum FileName
    {
        config,
        players,
        text,
        spawn,
        mission,
        log,
    }

    public enum General
    {
        id,
        color,
        asigned,
        count,
        name
    }

    //endregion

    //region METHODS
    
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    protected Base(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
        this.utils = new UtilsBL();
    }

    /**
     * Stardard method that handles the exceptions.
     * @param exc
     */
    protected void ExceptionManager(Exception exc)
    {
        this.utils.SendConsoleMessage(exc.getMessage());
        LogBL log = new LogBL(this.basicUtilities);
        log.SaveErrorMessage(exc.getMessage());
    }

    //region GETTERS

    /**
     * Method that handles get the file manager.
     * @return
     */
    protected FileManagerBL FileMananger()
    {
        return this.basicUtilities.fileManager;
    }
    
    /**
     * Method that handles get basicUtilities.
     * @return
     */
    protected BasicUtilities BasicUtilities()
    {
        return this.basicUtilities;
    }

    /**
     * Method that handles get the utils.
     * @return
     */
    protected UtilsBL Utils()
    {
        return this.utils;
    }

    //endregion

    //endregion
}
