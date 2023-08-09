package BusinessLogic;

import org.bukkit.potion.PotionEffectType;

import Base.BaseBL;
import Entities.RankDTO;
import Main.BasicUtilities;

/**
 * Class that handles the ranking config.
 */
public class RankBL extends BaseBL
{
    //region METHODS

    /**
	 * Constructor
	 * @param objBasicUtilities
	 */
    public RankBL(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities, FileName.ranking);
    }

    /**
     * Method that handles the rank information.
     * @param rank
     * @return
     */
    public RankDTO GetRank(Ranking rank)
    {
        RankDTO rankDTO = new RankDTO();
        rankDTO.Rank = rank;
        rankDTO.Id = GetInt(rank, General.id);
        rankDTO.Effect = GetEffectById(0);
        rankDTO.Duration = GetInt(rank, Ranking.duration);
        rankDTO.Level = GetInt(rank, Ranking.level);

        return rankDTO;
    }

    /**
     * Method that handles the effects by ranking.
     * @param effect
     * @return
     */
    private PotionEffectType GetEffectById(int effect)
    {
        return switch (effect)
        {
            case 1 -> PotionEffectType.SPEED;
            case 2 -> PotionEffectType.FAST_DIGGING;
            case 3 -> PotionEffectType.JUMP;
            case 4 -> PotionEffectType.NIGHT_VISION;
            case 5 -> PotionEffectType.REGENERATION;
            case 6 -> PotionEffectType.SATURATION;
            case 7 -> PotionEffectType.FIRE_RESISTANCE;
            case 8 -> PotionEffectType.ABSORPTION;
            case 9 -> PotionEffectType.DAMAGE_RESISTANCE;
            default -> null;
        };
    }

    //endregion
}
