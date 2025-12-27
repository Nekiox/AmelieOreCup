package fr.nekiox.halloween_event;

import fr.nekiox.custom_events.PlayerDeathByPlayerEvent;
import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.mineral.Core.Game.Game;
import fr.nekiox.mineral.DeathAnimations.Animations.HalloweenHurricaneAnimation;
import fr.nekiox.mineral.DeathAnimations.DeathAnimation;
import fr.nekiox.mineral.Settings.GameSettings;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Random;

/**
 * Fonction appelée lors de la mort d'un joueur
 */
public class PlayerDeathEvent implements Listener {

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathByPlayerEvent event) {

        Game partie = event.getPartie();

        if(partie == null) return;

        GameSettings parametres = partie.groupe.getParametresPartie();
        boolean halloweenEnabled = (parametres.getCVAR("enable_halloween_event").getValeurNumerique() == 1);

        // On désactive l'event halloween pour l'instant
        halloweenEnabled = false;
        if(!halloweenEnabled) return;

        DeathAnimation animationMort = new HalloweenHurricaneAnimation();
        animationMort.playAnimation(event.getPlayerDead());


        // On récupère le groupe
        Groupe playerGroup = mineralcontest.getPlayerGroupe(event.getKiller());
        if(playerGroup == null) return;

        // Pour chaque joueur du groupe
        for(Player joueurGroupe : playerGroup.getPlayers()) {
            // Si il n'est pas arbitre
            if(!playerGroup.getGame().isReferee(joueurGroupe) && !joueurGroupe.equals(event.getKiller()) && !joueurGroupe.equals(event.getPlayerDead())) {
                // On lui joue un son
                joueurGroupe.playSound(joueurGroupe.getLocation(), getRandomSound(), 0.8f, 1);
            }
        }

    }


    private Sound getRandomSound() {
        Sound[] sounds = new Sound[]{Sound.ENTITY_ZOMBIE_AMBIENT, Sound.ENTITY_CREEPER_PRIMED, Sound.BLOCK_STONE_STEP, Sound.ENTITY_SPIDER_AMBIENT, Sound.ENTITY_SPIDER_STEP, Sound.ENTITY_ENDERMAN_AMBIENT, Sound.ENTITY_ENDERMAN_TELEPORT, Sound.ENTITY_ENDERMAN_SCREAM};

        int random = new Random().nextInt(sounds.length);
        return sounds[random];
    }

}
