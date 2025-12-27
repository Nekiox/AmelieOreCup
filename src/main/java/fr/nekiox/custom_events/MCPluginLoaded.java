package fr.nekiox.custom_events;

import fr.nekiox.custom_plugins.CustomPlugin;

public class MCPluginLoaded extends MCEvent {

    private CustomPlugin plugin;

    public MCPluginLoaded(CustomPlugin plugin) {
        this.plugin = plugin;
    }

    public CustomPlugin getPlugin() {
        return plugin;
    }
}
