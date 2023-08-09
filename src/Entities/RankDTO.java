package Entities;

import org.bukkit.potion.PotionEffectType;

import Base.Base.Ranking;

/**
 * Class that handles the rank information.
 */
public class RankDTO
{
    public int Id;
    public Ranking Rank;
    public PotionEffectType Effect;
    public int Duration = 86400;
    public int Level = 1;
}