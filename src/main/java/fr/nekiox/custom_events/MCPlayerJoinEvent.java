package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.MCPlayer;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.entity.Player;

/**
 * Evenement envoyé lors du démarrage d'une game
 */
public class MCPlayerJoinEvent extends MCEvent {



    private MCPlayer mcPlayer;

    private Player player;

    public MCPlayerJoinEvent(Player p) {
        this.player = p;

        MCPlayer mcPlayer = mineralcontest.plugin.getMCPlayer(p);
        if(mcPlayer == null) this.mcPlayer = new MCPlayer(p);
        else this.mcPlayer = mcPlayer;

    }

    public MCPlayer getMcPlayer() {
        return mcPlayer;
    }

    public Player getPlayer() {
        return player;
    }

}
