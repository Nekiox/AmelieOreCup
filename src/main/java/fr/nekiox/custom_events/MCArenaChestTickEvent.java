package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.Game.Game;

public class MCArenaChestTickEvent extends MCEvent {

    private Game game;
    private int timeLeft;



    public MCArenaChestTickEvent(int timeLeft, Game partie) {
        this.timeLeft = timeLeft;
        this.game = partie;
    }

    public Game getGame() {
        return game;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

}
