package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.Game.Game;

/**
 * Evenement envoyé lors du démarrage d'une game
 */
public class MCGameStartedEvent extends MCEvent {

    private Game game;

    public MCGameStartedEvent(Game partie) {
        this.game = partie;
    }

    public Game getGame() {
        return game;
    }

}
