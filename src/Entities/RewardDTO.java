package Entities;

import java.util.List;

import org.bukkit.potion.PotionEffectType;

/**
 * Class that handles the reward information.
 */
public class RewardDTO
{
    public int RewardId;
    public int MaterialId;
    public int Amount;
    public String MissionName;

    // For tools
    public String Name;
    public String Lore;

    // For potions

    public List<PotionEffectType> Effect;
}
