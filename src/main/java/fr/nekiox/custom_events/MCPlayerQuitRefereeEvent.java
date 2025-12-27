package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.MCPlayer;
import org.bukkit.event.Cancellable;

/**
 * Event appelé lorsqu'un joueur n'est plus arbitre
 */
public class MCPlayerQuitRefereeEvent extends MCEvent implements Cancellable {

    private boolean isCancelled;
    private MCPlayer player;

    public MCPlayerQuitRefereeEvent(MCPlayer player) {
        this.player = player;
    }

    public MCPlayer getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }
}
