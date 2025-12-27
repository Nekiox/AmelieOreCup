package fr.nekiox.custom_events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MCPlayerWorldChangeEvent extends MCEvent {

    private Location fromLocation;
    private World fromWorld;

    private Location toLocation;
    private World toWorld;

    private Player player;

    public MCPlayerWorldChangeEvent(Location from, Location to, Player player) {
        this.fromLocation = from;
        this.fromWorld = from.getWorld();

        this.toLocation = to;
        this.toWorld = to.getWorld();

        this.player = player;
    }


    public Location getFromLocation() {
        return fromLocation;
    }

    public World getFromWorld() {
        return fromWorld;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public World getToWorld() {
        return toWorld;
    }

    public Player getPlayer() {
        return player;
    }
}
