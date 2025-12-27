package fr.nekiox.mineral.Shop.Categories;

import fr.nekiox.mineral.Shop.Categories.Abstract.Category;
import fr.nekiox.mineral.Shop.NPCs.BonusSeller;
import fr.nekiox.mineral.Translation.Lang;
import org.bukkit.Material;

public class Items extends Category {

    public Items(BonusSeller npc) {
        super(npc);
    }

    @Override
    public String getNomCategorie() {
        return Lang.items_category_title.toString();
    }

    @Override
    public Material getItemMaterial() {
        return Material.GOLDEN_APPLE;
    }

    @Override
    public String[] getDescription() {
        return new String[0];
    }
}
