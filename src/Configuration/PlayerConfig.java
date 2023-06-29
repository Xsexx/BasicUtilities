package Configuration;

import java.io.File;

import Main.BasicUtilities;

public class PlayerConfig
{
    private BasicUtilities basicUtilities;
    
    public PlayerConfig(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
		File config = new File(this.basicUtilities.getDataFolder(),"Player.yml");
		// String rutaConfig = config.getPath();
		
        if(!config.exists())
        {
			this.basicUtilities.getConfig().options().copyDefaults(true);
			this.basicUtilities.saveConfig();
		}
	}

}
