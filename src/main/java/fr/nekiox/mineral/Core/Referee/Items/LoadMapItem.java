package fr.nekiox.mineral.Core.Referee.Items;

import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.groups.Utils.Etats;
import fr.nekiox.mineral.Core.Referee.Inventory.InventoryTemplate;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class LoadMapItem extends RefereeItemTemplate {


    public LoadMapItem(Object target, InventoryTemplate inventaireSource) {
        super(target, inventaireSource);
    }

    public LoadMapItem(String nomMap, Object target, InventoryTemplate inventaireSource) {
        super(nomMap, target, inventaireSource);
    }

    @Override
    public void performClick(Player joueur) {
        Groupe groupe = mineralcontest.getPlayerGroupe(joueur);
        if (groupe == null || !groupe.getEtatPartie().equals(Etats.EN_ATTENTE)) {
            joueur.sendMessage(mineralcontest.prefixErreur + Lang.referee_error_map_selector_only_hub.toString());
            return;
        }

        if (customName.length() > 1) {
            groupe.chargerMonde(customName);
        }
    }

    @Override
    public String getNomItem() {
        return customName;
    }

    @Override
    public String getDescriptionItem() {
        return Lang.referee_item_map_selector_description.toString() + customName;
    }

    @Override
    public Material getItemMaterial() {
        return Material.PAPER;
    }
}
