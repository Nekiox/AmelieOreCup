package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.Game.Game;
import org.bukkit.Location;

public class MCAirDropSpawnEvent extends MCEvent {
    private Game game;
    private Location dropLocation;



    public MCAirDropSpawnEvent(Location drop, Game partie) {
        this.dropLocation = drop;
        this.game = partie;
    }

    public Game getGame() {
        return game;
    }

    public Location getParachuteLocation() {
        return dropLocation;
    }



}
