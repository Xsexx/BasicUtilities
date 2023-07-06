package BusinessLogic;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Base.Base;
import Main.BasicUtilities;

public class ItemBL extends Base
{
    public ItemBL(BasicUtilities objBasicUtilities)
    {
        this.basicUtilities = objBasicUtilities;
    }

    public ItemStack GetPotion(int amount)
    {
        ItemStack potion = new ItemStack(Material.SPLASH_POTION, amount);

        PotionMeta potionmeta = (PotionMeta) potion.getItemMeta();
        PotionEffect speed = new PotionEffect(PotionEffectType.HEAL, 1000, 1);
        PotionEffect reg = new PotionEffect(PotionEffectType.REGENERATION, 1000, 1);
        potionmeta.addCustomEffect(speed, true);
        potionmeta.addCustomEffect(reg, true);
        potionmeta.setDisplayName("@nombre");
        potion.setItemMeta(potionmeta);

        return potion;
    }
}
