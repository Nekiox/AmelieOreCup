package fr.nekiox.world_downloader.Inventories;

import fr.nekiox.groups.Core.MapVote;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.world_downloader.Items.ActionMapItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GestionMapsInventory extends InventoryInterface {


    public GestionMapsInventory(boolean displayInMainMenu) {
        super(displayInMainMenu);
    }

    @Override
    public void setInventoryItems(Player arbitre) {

        MapVote mapVote = new MapVote();
        ArrayList<String> maps = mapVote.getMaps();
        for (String nomMap : maps)
            registerItem(new ActionMapItem(nomMap));

        mapVote = null;
    }

    @Override
    public Material getItemMaterial() {
        return Material.RED_CONCRETE;
    }

    @Override
    public String getNomInventaire() {
        return Lang.map_downloader_delete_title.toString();
    }

    @Override
    public String getDescriptionInventaire() {
        return Lang.map_downloader_delete_title.toString();
    }
}
