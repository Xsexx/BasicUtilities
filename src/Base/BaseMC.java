package Base;

import BusinessLogic.FileManagerBL;
import BusinessLogic.TextBL;
import Main.BasicUtilities;

public class BaseMC extends Base
{
    //region VARIABLES.

    protected TextBL text;

    //endregion

    //region Methods
    
    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public BaseMC(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities);
        this.text = new TextBL(basicUtilities);
        this.fileManager = new FileManagerBL(objBasicUtilities);
    }

    //endregion
    
}
