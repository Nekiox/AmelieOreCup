package fr.nekiox.mineral.Events;

import fr.nekiox.custom_events.MCPlayerLeavePluginEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Evenement appelé lorsqu'un joueur quitte le serveur ou le plugin
 */
public class MCPlayerLeavePlugin implements Listener {

    @EventHandler
    public void onPlayerDisconnect(MCPlayerLeavePluginEvent event) {
        // On traite seulement les déconnexions
        // On déconnecte le joueur
        event.getMcPlayer().disconnectPlayer();
    }


}
