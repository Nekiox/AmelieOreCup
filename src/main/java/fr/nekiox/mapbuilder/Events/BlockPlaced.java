package fr.nekiox.mapbuilder.Events;

import fr.nekiox.mapbuilder.Blocks.BlocksDataColor;
import fr.nekiox.mapbuilder.Items.AreneItem;
import fr.nekiox.mapbuilder.Items.ColoredHouseItem;
import fr.nekiox.mapbuilder.MapBuilder;
import fr.nekiox.mapbuilder.Spawner.Arene;
import fr.nekiox.mapbuilder.Spawner.House;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlaced implements Listener {
    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {

        if (!MapBuilder.getInstance().isBuilderModeEnabled) return;
        ItemStack placedItem = event.getItemInHand();
        String itemName = placedItem.getItemMeta().getDisplayName();
        Player player = event.getPlayer();

        if (itemName.contains(ColoredHouseItem.itemPrefix)) {
            placedItem.setType(Material.AIR);
            Location spawnItemLocation = event.getBlock().getLocation();
            House.spawn(BlocksDataColor.fromItemName(itemName), player);
            event.setCancelled(true);
        }

        if (itemName.equalsIgnoreCase(AreneItem.itemPrefix)) {
            Arene.spawn(player);
            event.setCancelled(true);
        }


    }
}
