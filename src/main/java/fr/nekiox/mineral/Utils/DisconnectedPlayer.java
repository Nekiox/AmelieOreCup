package fr.nekiox.mineral.Utils;

import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.mineral.Kits.KitAbstract;
import fr.nekiox.mineral.Shop.Items.Abstract.ShopItem;
import fr.nekiox.mineral.Teams.Equipe;
import fr.nekiox.mineral.Utils.Player.CouplePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Classe permettant de gérer les joueurs se déconnectant
 */
public class DisconnectedPlayer {
    private UUID playerUUID;
    private Equipe oldPlayerTeam;
    private Groupe oldPlayerGroupe;
    private CouplePlayer oldPlayerDeathTime;
    private Location oldPlayerLocation;
    private List<ItemStack> oldPlayerInventory;
    private LinkedBlockingQueue<ShopItem> bonus;
    private KitAbstract kit;


    public DisconnectedPlayer(UUID playerUUID, Equipe oldPlayerTeam, Groupe oldPlayerGroupe, CouplePlayer oldPlayerDeathTime, Location oldPlayerLocation, Player p, LinkedBlockingQueue bonus, KitAbstract kit) {
        this.playerUUID = playerUUID;
        this.oldPlayerTeam = oldPlayerTeam;
        this.oldPlayerGroupe = oldPlayerGroupe;
        this.oldPlayerDeathTime = oldPlayerDeathTime;
        this.oldPlayerLocation = oldPlayerLocation;
        this.oldPlayerInventory = new LinkedList<>();
        this.bonus = bonus;
        this.kit = kit;

        Bukkit.getLogger().info(oldPlayerLocation + "");



        for (ItemStack item : p.getInventory().getStorageContents())
            if (item != null) oldPlayerInventory.add(item);


    }


    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public Equipe getOldPlayerTeam() {
        return oldPlayerTeam;
    }

    public Groupe getOldPlayerGroupe() {
        return oldPlayerGroupe;
    }

    public CouplePlayer getOldPlayerDeathTime() {
        return oldPlayerDeathTime;
    }

    public Location getOldPlayerLocation() {
        return oldPlayerLocation;
    }

    public boolean wasPlayerDead() {
        return (oldPlayerDeathTime != null && oldPlayerDeathTime.getValeur() > 0);
    }


    public List<ItemStack> getOldPlayerInventory() {
        return oldPlayerInventory;
    }

    public LinkedBlockingQueue<ShopItem> getBonus() {
        return bonus;
    }

    public KitAbstract getKit() {
        return kit;
    }


}
