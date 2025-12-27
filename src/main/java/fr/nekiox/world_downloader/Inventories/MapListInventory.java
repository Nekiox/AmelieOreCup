package fr.nekiox.world_downloader.Inventories;

import fr.nekiox.groups.Core.MapVote;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.world_downloader.Items.AllMapDownloadItem;
import fr.nekiox.world_downloader.Items.MapDownloadItem;
import fr.nekiox.world_downloader.MapInfo;
import fr.nekiox.world_downloader.WorldDownloader;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedList;

public class MapListInventory extends InventoryInterface {


    public MapListInventory(boolean displayInMainMenu) {
        super(displayInMainMenu);
    }

    @Override
    public void setInventoryItems(Player arbitre) {
        LinkedList<MapInfo> maps_available = WorldDownloader.getMaps(false);

        MapVote mapVote = new MapVote();
        ArrayList<String> maps_telecharger = mapVote.getMaps();

        for (MapInfo map : maps_available)
            if (!maps_telecharger.contains(map.map_folder_name))
                registerItem(MapDownloadItem.fromMapInfo(map));

        registerItem(new AllMapDownloadItem());

    }

    @Override
    public Material getItemMaterial() {
        return Material.MAP;
    }

    @Override
    public String getNomInventaire() {
        return Lang.map_downloader_inventory_name.toString();
    }

    @Override
    public String getDescriptionInventaire() {
        return Lang.map_downloader_inventory_name.toString();
    }
}
