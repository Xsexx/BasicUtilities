package DataAccess;

import java.io.File;

import Main.BasicUtilities;

public class PlayerDA
{
    private BasicUtilities basicUtilities;
    
    public PlayerDA(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
		File config = new File(this.basicUtilities.getDataFolder(),"player.yml");
		
        if(!config.exists())
        {
			this.basicUtilities.getConfig().options().copyDefaults(true);
			this.basicUtilities.saveConfig();
		}
	}

}
