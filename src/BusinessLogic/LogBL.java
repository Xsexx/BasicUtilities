package BusinessLogic;

import java.util.List;

import Base.BaseBL;
import Main.BasicUtilities;

/**
 * Class that handles the log config.
 */
public class LogBL extends BaseBL
{
    /**
     * Constructor
     * @param objBasicUtilities
     */
    public LogBL(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities, FileName.log);
    }
    
    /**
     * Method that handles the error text of exception.
     * @param error
     * @return
     */
    public void SaveErrorMessage(String error)
	{
		List<String> errorList = GetStringList(Log.log);
        errorList.add(error);
		Set(errorList, Log.log);
		SaveFile();
	}
}
