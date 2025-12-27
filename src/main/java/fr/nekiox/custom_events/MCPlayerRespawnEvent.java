package fr.nekiox.custom_events;

import org.bukkit.entity.Player;

public class MCPlayerRespawnEvent extends MCEvent {


    private Player joueur;


    public MCPlayerRespawnEvent(Player joueur) {
        this.joueur = joueur;
    }

    public Player getJoueur() {
        return joueur;
    }

}
