package Base;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

/**
 * Super class that handles the general attributes for business logic.
 */
public class BaseBL extends Base
{
    //region VARIABLES
    protected FileConfiguration config;
    protected File file;
    //endregion

    //region TEXT FILES PROPERTIES
    protected StringBuilder BASE = new StringBuilder();
    //endregion

    //region ENUMS
    public enum FileConfig
    {
        Config, Player, Text
    }
    //endregion
}
