package fr.nekiox.custom_events;

import fr.nekiox.groups.Core.Groupe;
import org.bukkit.World;

/**
 * Event appelé lorsqu'un monde mineral contest est chargé
 */
public class MCWorldLoadedEvent extends MCEvent {

    private World monde;
    private String world_name = "";
    private Groupe groupe;

    public MCWorldLoadedEvent(String world_name, World w, Groupe groupe) {
        this.monde = w;
        this.world_name = world_name;
        this.groupe = groupe;
    }


    public World getMonde() {
        return monde;
    }

    public String getWorld_name() {
        return world_name;
    }

    public Groupe getGroupe() {
        return groupe;
    }
}
