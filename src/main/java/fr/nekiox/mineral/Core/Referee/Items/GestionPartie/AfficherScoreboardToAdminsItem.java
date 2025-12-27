package fr.nekiox.mineral.Core.Referee.Items.GestionPartie;

import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.mineral.Core.House;
import fr.nekiox.mineral.Core.Referee.Inventory.InventoryTemplate;
import fr.nekiox.mineral.Core.Referee.Items.RefereeItemTemplate;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class AfficherScoreboardToAdminsItem extends RefereeItemTemplate {


    public AfficherScoreboardToAdminsItem(Object target, InventoryTemplate inventaireSource) {
        super(target, inventaireSource);
    }

    @Override
    public void performClick(Player joueur) {
        Groupe groupe = mineralcontest.getPlayerGroupe(joueur);
        if (groupe == null || !groupe.getGame().isGameStarted()) return;

        int teamNonEmpty = 0;
        for (House maison : groupe.getGame().getHouses()) {
            if (!maison.getTeam().getJoueurs().isEmpty()) {
                groupe.sendToadmin(Lang.translate(Lang.team_score.toString(), maison.getTeam()));
                teamNonEmpty++;
            }
        }

        if (teamNonEmpty == 0)
            joueur.sendMessage(mineralcontest.prefixErreur + Lang.error_no_teams_with_player.toString());

    }

    @Override
    public String getNomItem() {
        return Lang.referee_item_show_score_to_admin_title.toString();
    }

    @Override
    public String getDescriptionItem() {
        return Lang.referee_item_show_score_to_admin_description.toString();
    }

    @Override
    public Material getItemMaterial() {
        return Material.GOLD_INGOT;
    }
}
