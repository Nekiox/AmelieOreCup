package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.MCPlayer;

/**
 * Event appelé lorsqu'un joueur se reconnecte au plugin
 */
public class MCPlayerReconnectEvent extends MCEvent{

    private MCPlayer player;

    public MCPlayerReconnectEvent(MCPlayer player) {
        this.player = player;
    }

    public MCPlayer getPlayer() {
        return player;
    }
}
