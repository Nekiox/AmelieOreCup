package fr.nekiox.custom_events;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MCEvent extends Event {

    private static final HandlerList handlers = new HandlerList();


    public MCEvent() {
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public void callEvent() {
        Bukkit.getServer().getPluginManager().callEvent(this);
    }
}
