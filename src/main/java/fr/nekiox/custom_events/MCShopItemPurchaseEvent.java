package fr.nekiox.custom_events;

import fr.nekiox.mineral.Shop.Items.Abstract.ShopItem;
import org.bukkit.entity.Player;

public class MCShopItemPurchaseEvent extends MCEvent {
    private Player joueur;
    private ShopItem item;


    public MCShopItemPurchaseEvent(ShopItem item, Player acheteur) {
        this.item = item;
        this.joueur = acheteur;
    }

    public Player getJoueur() {
        return joueur;
    }

    public ShopItem getItem() {
        return item;
    }
}
