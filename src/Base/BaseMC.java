package Base;

import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class BaseMC extends Base
{
    //region VARIABLES.
    protected TextBL text;
    //endregion

    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public BaseMC(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
        this.text = new TextBL(basicUtilities);
    }
}
