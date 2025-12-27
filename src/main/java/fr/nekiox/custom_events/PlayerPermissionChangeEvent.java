package fr.nekiox.custom_events;

import org.bukkit.entity.Player;

public class PlayerPermissionChangeEvent extends MCEvent {

    private Player player;
    private String oldPermission;
    private String newPermission;



    public PlayerPermissionChangeEvent(Player p, String old, String new_p) {
        this.player = p;
        this.oldPermission = old;
        this.newPermission = new_p;
    }


    public Player getPlayer() {
        return player;
    }

    public String getOldPermission() {
        return oldPermission;
    }

    public String getNewPermission() {
        return newPermission;
    }

}
