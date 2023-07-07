package Base;

import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class BaseMC extends Base
{
    //region VARIABLES.
    protected TextBL templates;
    //endregion

    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public BaseMC(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
        this.templates = new TextBL(basicUtilities);
    }
}
