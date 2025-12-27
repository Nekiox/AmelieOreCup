package fr.nekiox.mineral.Core.Parachute.Events;

import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.mineral.Core.Parachute.Parachute;
import fr.nekiox.mineral.Core.Parachute.ParachuteManager;
import fr.nekiox.mineral.Statistics.Class.MostParachuteHitStat;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ParachuteHitDetection implements Listener {

    /**
     * Fonction appelée lors d'une detection d'un tir de fleche qui touche quelque chose
     *
     * @param event
     */
    @EventHandler
    public void onBlockHitByArrow(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Arrow fleche = (Arrow) event.getEntity();

            // On vérifie si le tireur est un joueur
            if (fleche.getShooter() instanceof Player) {
                Player tireur = (Player) fleche.getShooter();

                // On regarde si le tireur fait parti du plugin
                if (mineralcontest.isInAMineralContestWorld(tireur)) {
                    // On récupère le groupe du joueur
                    Groupe playerGroup = mineralcontest.getPlayerGroupe(tireur);

                    // SI il n'a pas de groupe, on s'en fou et on arrête
                    if (playerGroup == null || playerGroup.getGame() == null || !playerGroup.getGame().isGameStarted())
                        return;

                    ParachuteManager parachuteManager = playerGroup.getGame().getParachuteManager();

                    if (parachuteManager == null) return;


                    for (Parachute parachute : parachuteManager.getParachutes())
                        if (parachute.isParachuteHit(fleche)) {
                            parachute.receiveDamage(fleche.getDamage(), fleche.getLocation());

                            // On enregistre le hit
                            playerGroup.getGame().getStatsManager().register(MostParachuteHitStat.class, tireur, null);
                            fleche.remove();
                        }
                }
            }
        }
    }
}
