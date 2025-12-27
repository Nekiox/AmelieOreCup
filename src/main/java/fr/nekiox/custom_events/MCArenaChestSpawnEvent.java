package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.Game.Game;

public class MCArenaChestSpawnEvent extends MCEvent {
    private Game game;

    public MCArenaChestSpawnEvent(Game partie) {
        this.game = partie;
    }

    public Game getGame() {
        return game;
    }

}
