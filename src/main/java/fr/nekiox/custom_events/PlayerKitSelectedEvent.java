package fr.nekiox.custom_events;

import fr.nekiox.mineral.Kits.KitAbstract;
import org.bukkit.entity.Player;

/**
 * Evenement appelé lors de la selection d'un kit
 */
public class PlayerKitSelectedEvent extends MCEvent {


    private Player player;
    private KitAbstract selectedKit;



    public PlayerKitSelectedEvent(Player joueur, KitAbstract selectedKit) {
        this.player = joueur;
        this.selectedKit = selectedKit;
    }

    public Player getPlayer() {
        return player;
    }

    public KitAbstract getSelectedKit() {
        return selectedKit;
    }

}
