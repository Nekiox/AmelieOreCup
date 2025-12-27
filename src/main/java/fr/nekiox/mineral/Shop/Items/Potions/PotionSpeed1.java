package fr.nekiox.mineral.Shop.Items.Potions;

import fr.nekiox.mineral.Shop.Items.Abstract.PotionItem;
import fr.nekiox.mineral.Shop.ShopManager;
import fr.nekiox.mineral.Translation.Lang;
import org.bukkit.potion.PotionEffectType;

public class PotionSpeed1 extends PotionItem {
    @Override
    public String getNomItem() {
        return Lang.shopitem_speed1_title.toString();
    }

    @Override
    public String[] getDescriptionItem() {
        return new String[]{Lang.shopitem_speed1_desc.toString()};
    }

    @Override
    public int getPrice() {
        return ShopManager.getBonusPriceFromName("speed1_potion");
    }


    @Override
    public PotionEffectType getPotionType() {
        return PotionEffectType.SPEED;
    }

    @Override
    public int getPotionLevel() {
        return 1;
    }

    @Override
    public int getPotionDuration() {
        return 5;
    }
}
