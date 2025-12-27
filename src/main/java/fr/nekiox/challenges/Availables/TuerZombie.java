package fr.nekiox.challenges.Availables;

import fr.nekiox.challenges.ChallengeManager;
import fr.nekiox.challenges.Rewards.AbstractReward;
import fr.nekiox.challenges.Rewards.PointsReward;
import fr.nekiox.mineral.Core.MCPlayer;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class TuerZombie extends AbstractRepeatableChallenge {
    public TuerZombie(ChallengeManager manager) {
        super(manager);
    }

    @Override
    public int repetitionNeeded() {
        return 25;
    }

    @Override
    public String getNom() {
        return "The Walking Dead";
    }

    @Override
    public String getObjectifTexte() {
        return "Tuez " + repetitionNeeded() + " zombies pour remporter 500 points!";
    }

    @Override
    public AbstractReward getReward() {
        return new PointsReward(500);
    }


    @EventHandler
    public void onZombieKilled(EntityDeathEvent event) {
        if(event.getEntity().getKiller() != null) {

            Player joueur = event.getEntity().getKiller();

            MCPlayer mcPlayer = mineralcontest.plugin.getMCPlayer(joueur);
            if(mcPlayer == null) return;

            if(getManager().doesPlayerHaveThisAchievement(mcPlayer, this)) {
                if(event.getEntity() instanceof Zombie) {
                    getManager().playerDidAchievement(mcPlayer, this);
                }
            }
        }
    }
}
