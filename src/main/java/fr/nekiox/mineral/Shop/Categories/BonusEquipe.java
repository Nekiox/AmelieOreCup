package fr.nekiox.mineral.Shop.Categories;

import fr.nekiox.mineral.Shop.Categories.Abstract.Category;
import fr.nekiox.mineral.Shop.NPCs.BonusSeller;
import fr.nekiox.mineral.Translation.Lang;
import org.bukkit.Material;

public class BonusEquipe extends Category {

    public BonusEquipe(BonusSeller npc) {
        super(npc);
    }

    @Override
    public String getNomCategorie() {
        return Lang.teambonus_category_title.toString();
    }

    @Override
    public Material getItemMaterial() {
        return Material.ENDER_CHEST;
    }

    @Override
    public String[] getDescription() {
        return new String[0];
    }
}
