package Entities;

import java.time.LocalDateTime;

import org.bukkit.entity.Player;

/**
 * Class that handles the player information.
 */
public class PlayerDTO
{
    public String Id;
    public String Name;
    public Player PlayerMC;
    public LocalDateTime LastConection;
    public RankDTO Rank;
}
