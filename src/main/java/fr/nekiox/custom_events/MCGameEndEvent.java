package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.Game.Game;

/**
 * Evenement symbolisant la fin d'une partie
 */
public class MCGameEndEvent extends MCEvent {


    private Game partie;




    public MCGameEndEvent(Game partie) {
        this.partie = partie;
    }


    public Game getGame() {
        return partie;
    }

}
