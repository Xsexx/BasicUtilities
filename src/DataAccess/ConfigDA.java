package dataAccess;

import java.io.File;

import main.BasicUtilities;

public class ConfigDA
{
    private BasicUtilities basicUtilities;
    
    public ConfigDA(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
		File config = new File(this.basicUtilities.getDataFolder(),"config.yml");
        this.basicUtilities.rutaConfig = config.getPath();
		
        if(!config.exists())
        {
			this.basicUtilities.getConfig().options().copyDefaults(true);
			this.basicUtilities.saveConfig();
		}
	}
}