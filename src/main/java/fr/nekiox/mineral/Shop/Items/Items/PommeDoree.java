package fr.nekiox.mineral.Shop.Items.Items;

import fr.nekiox.mineral.Shop.Items.Abstract.GameItem;
import fr.nekiox.mineral.Shop.ShopManager;
import fr.nekiox.mineral.Translation.Lang;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PommeDoree extends GameItem {
    @Override
    public String getNomItem() {
        return Lang.shopitem_goldenapple_title.toString();
    }

    @Override
    public String[] getDescriptionItem() {
        return new String[]{Lang.shopitem_goldenapple_desc.toString()};
    }

    @Override
    public Material getItemMaterial() {
        return Material.GOLDEN_APPLE;
    }

    @Override
    public void onItemUse() {
        this.joueur.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
    }

    @Override
    public int getPrice() {
        return ShopManager.getBonusPriceFromName("golden_apple");
    }

}
