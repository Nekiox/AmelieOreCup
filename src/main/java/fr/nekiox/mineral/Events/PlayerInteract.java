package fr.nekiox.mineral.Events;

import fr.nekiox.mapbuilder.MapBuilder;
import fr.nekiox.mineral.Core.Game.Game;
import fr.nekiox.mineral.Exception.EventAlreadyHandledException;
import fr.nekiox.mineral.Shop.Items.Items.BouleDeFeu;
import fr.nekiox.mineral.Shop.NPCs.Event.NPCPlayerInteract;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.mineral.Utils.Setup;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (MapBuilder.getInstance().isBuilderModeEnabled) return;

        try {
            BouleDeFeu.FireballPlayerInteractEvent(event);
        } catch (EventAlreadyHandledException e) {
            return;
        }

        World worldEvent = event.getPlayer().getWorld();
        if (mineralcontest.isAMineralContestWorld(worldEvent)) {
            Player joueur = (Player) event.getPlayer();
            Game partie = mineralcontest.getWorldGame(worldEvent);

            if (mineralcontest.isInMineralContestHub(joueur) && mineralcontest.enable_lobby_block_protection) {
                event.setCancelled(true);

                if (event.getClickedBlock() != null && mineralcontest.enable_block_warning)
                    event.getPlayer().sendMessage(mineralcontest.prefixPrive + Lang.cant_interact_block_pre_game.toString());
                return;
            }


            if (partie != null && !partie.isGameStarted() && (event.getAction().equals(Action.LEFT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && !Setup.premierLancement) {
                event.setCancelled(true);
                if(mineralcontest.enable_block_warning) event.getPlayer().sendMessage(mineralcontest.prefixPrive + Lang.cant_interact_block_pre_game.toString());
            }

        }


    }

    @EventHandler
    public void blockVillagerTrades(PlayerInteractAtEntityEvent entityEvent) {
        if (MapBuilder.getInstance().isBuilderModeEnabled) return;


        World current_world = entityEvent.getPlayer().getWorld();
        if (mineralcontest.isAMineralContestWorld(current_world)) {
            Player p = entityEvent.getPlayer();

            try {
                NPCPlayerInteract.OnPlayerRightClick(entityEvent);
            } catch (EventAlreadyHandledException e) {
                return;
            }

            if (entityEvent.getRightClicked() instanceof Villager ||
                    entityEvent.getRightClicked() instanceof Witch ||
                    entityEvent.getRightClicked() instanceof TraderLlama ||
                    entityEvent.getRightClicked() instanceof WanderingTrader ||
                    entityEvent.getRightClicked() instanceof Golem ||
                    entityEvent.getRightClicked() instanceof IronGolem) {
                entityEvent.setCancelled(true);
                entityEvent.getPlayer().closeInventory();
                entityEvent.getRightClicked().remove();
            }
        }

    }
}
