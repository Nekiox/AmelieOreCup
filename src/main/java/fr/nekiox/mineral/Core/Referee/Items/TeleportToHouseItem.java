package fr.nekiox.mineral.Core.Referee.Items;

import fr.nekiox.mineral.Core.Referee.Inventory.InventoryTemplate;
import fr.nekiox.mineral.Teams.Equipe;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.mineral.Utils.ChatColorString;
import fr.nekiox.mineral.Utils.Player.PlayerUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TeleportToHouseItem extends RefereeItemTemplate {

    public TeleportToHouseItem(Object target, InventoryTemplate inventaireSource) {
        super(target, inventaireSource);
    }

    @Override
    public void performClick(Player joueur) {
        if (target instanceof Equipe) {
            Equipe equipe = (Equipe) target;
            try {
                PlayerUtils.teleportPlayer(joueur, joueur.getWorld(), equipe.getMaison().getHouseLocation());
                joueur.sendMessage("Téléportation en cours ...");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getNomItem() {
        return Lang.translate(Lang.referee_item_teleport_to_house_title.toString(), (Equipe) target);
    }

    @Override
    public String getDescriptionItem() {
        return Lang.translate(Lang.referee_item_teleport_to_house_description.toString(), (Equipe) target);
    }

    @Override
    public Material getItemMaterial() {
        Equipe equipe = (Equipe) target;
        if (equipe == null) return Material.WHITE_WOOL;

        try {
            return Material.valueOf(ChatColorString.toStringEN(equipe.getCouleur()) + "_CONCRETE");
        } catch (IllegalArgumentException iae) {
            return Material.WHITE_WOOL;
        }

    }
}
