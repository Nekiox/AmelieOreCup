package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.Game.Game;

/**
 * Event appelé à chaque seconde
 */
public class MCGameTickEvent extends MCEvent{

    private Game game;

    public MCGameTickEvent(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
