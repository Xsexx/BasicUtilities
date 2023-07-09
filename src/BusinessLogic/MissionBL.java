package BusinessLogic;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Base.BaseBL;
import Entities.MissionDTO;
import Entities.RewardDTO;
import Main.BasicUtilities;

/**
 * Class that handles the mission config.
 */
public class MissionBL extends BaseBL
{
    public MissionBL(BasicUtilities objBasicUtilities)
    {
        super(objBasicUtilities, FileName.mission);
    }

    /**
     * Method that handles a mission per player.
     * @param missionId
     * @return
     */
    public MissionDTO GetMission(Properties missionId)
    {
        MissionDTO mission = new MissionDTO();

        try
        {
            mission.MissionId = missionId;
            mission.Name = GetString(missionId, Properties.name);

        }
        catch (Exception exc)
        {
            ExceptionManager(exc);
        }

        return mission;
    }

    /**
     * Method that handles the rewards per mission.
     * @param missionId
     * @return Reward's list.
     */
    public ArrayList<ItemStack> GetRewards(MissionDTO mission)
    {
        ArrayList<ItemStack> rewardList = new ArrayList<>();

        try
        {
            for (RewardDTO reward : mission.RewardList)
            {
                GetReward(reward);
            }
        }
        catch(Exception exc)
        {
            ExceptionManager(exc);
        }

        return rewardList;
    }

    /**
     * Method that handles create a reward.
     * @param reward
     * @return Reward
     */
    private ItemStack GetReward(RewardDTO reward)
    {
        ItemStack item;
        switch(Material.valueOf(reward.Name))
            {
                case SPLASH_POTION:
                    item = new ItemStack(Material.SPLASH_POTION, reward.Amount);
                    PotionMeta potionmeta = (PotionMeta) item.getItemMeta();
                    PotionEffect speed = new PotionEffect(PotionEffectType.HEAL, 1000, 1);
                    PotionEffect reg = new PotionEffect(PotionEffectType.REGENERATION, 1000, 1);
                    potionmeta.addCustomEffect(speed, true);
                    potionmeta.addCustomEffect(reg, true);
                    potionmeta.setDisplayName("@nombre");
                    item.setItemMeta(potionmeta);
                    break;
                case WOODEN_PICKAXE:
                case STONE_PICKAXE:
                case GOLDEN_PICKAXE:
                case IRON_PICKAXE:
                case DIAMOND_PICKAXE:
                case NETHERITE_PICKAXE:
                    // generamos picos.
                    item = new ItemStack(Material.valueOf(String.format("%s_%s", reward.Name, "PICKAXE")), reward.Amount);
                    break;
                default:
                    item = null;
                    break;
            }
        return item;
    }
}
