package BusinessLogic;

import java.util.List;

import Base.BaseBL;
import Main.BasicUtilities;

public class LogBL extends BaseBL
{

    public LogBL(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities, FileName.log);
    }
    
    public void SaveErrorMessage(String error)
	{
		List<String> errorList = GetStringList(Log.log);
        errorList.add(error);
		Set(errorList, Log.log);
		FileMananger().SaveFile(FileName.log);
	}
}
