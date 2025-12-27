package fr.nekiox.mineral.Statistics.Class;

import fr.nekiox.mineral.Statistics.MeilleurStatistic;
import fr.nekiox.mineral.Translation.Lang;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Enregistre les dépots de points négatif pour les autres équipes
 */
public class VilainJoueurStat extends MeilleurStatistic {
    @Override
    public void perform(Player p, Object target) {
        if (!(target instanceof Integer)) return;

        int nbPointAjoute = (Integer) target;
        if (!infoJoueurs.containsKey(p)) infoJoueurs.put(p, 0);

        int nbPointsRapporteTotal = infoJoueurs.get(p);
        infoJoueurs.replace(p, nbPointsRapporteTotal + nbPointAjoute);
    }

    @Override
    public String getHighestPlayerTitle() {
        return Lang.stats_mostpoints_taken_title.toString();
    }

    @Override
    public String getHighestItemSubTitle() {
        return Lang.stats_mostpoints_taken_subtitle.toString().replace("%d", getHighestPlayerValue() + "");
    }

    @Override
    public Material getHighestPlayerIcon() {
        return Material.REDSTONE;
    }
}
