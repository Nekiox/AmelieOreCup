package fr.nekiox.mineral.Core.Referee.Items.GestionPartie;

import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.mineral.Core.Referee.Inventory.InventoryTemplate;
import fr.nekiox.mineral.Core.Referee.Items.RefereeItemTemplate;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SpawnDropItem extends RefereeItemTemplate {

    public SpawnDropItem(Object target, InventoryTemplate inventaireSource) {
        super(target, inventaireSource);
    }

    @Override
    public void performClick(Player joueur) {
        Groupe groupe = mineralcontest.getPlayerGroupe(joueur);
        if (groupe == null) return;
        if (groupe.getGame() == null) return;

        if (groupe.getGame().isGameStarted()) {
            try {
                groupe.getGame().getParachuteManager().spawnNewParachute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            joueur.sendMessage(mineralcontest.prefixErreur + Lang.game_not_started.toString());
        }
    }

    @Override
    public String getNomItem() {
        return Lang.referee_item_spawn_drop_chest.toString();
    }

    @Override
    public String getDescriptionItem() {
        return "";
    }

    @Override
    public Material getItemMaterial() {
        return Material.FLETCHING_TABLE;
    }
}
