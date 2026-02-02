package fr.nekiox.mineral.Commands;

import fr.nekiox.groups.Commands.CommandTemplate;
import fr.nekiox.mineral.Core.MCPlayer;
import fr.nekiox.mineral.Scoreboard.newapi.ScoreboardAPI;
import fr.nekiox.mineral.mineralcontest;
import fr.nekiox.mineral.Events.PlayerHUDEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StreamerCommand extends CommandTemplate {

    public StreamerCommand() {
        accessCommande.add(PLAYER_COMMAND);
        accessCommande.add(GROUP_REQUIRED);
    }

    @Override
    public String getCommand() {
        return "streamer";
    }

    @Override
    public String getDescription() {
        return "Masque/affiche les coordonnées dans le scoreboard (mode streamer)";
    }

    @Override
    public String getPermissionRequise() {
        return null;
    }

    @Override
    public boolean performCommand(CommandSender commandSender, String command, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(mineralcontest.prefixErreur + "Cette commande est réservée aux joueurs.");
            return false;
        }

        Player joueur = (Player) commandSender;
        MCPlayer mcPlayer = mineralcontest.plugin.getMCPlayer(joueur);
        if (mcPlayer == null) return false;

        boolean enabled = ScoreboardAPI.toggleStreamerMode(joueur);

        if (enabled) {
            joueur.sendMessage(mineralcontest.prefixPrive + ChatColor.GREEN + "Mode streamer activé : coordonnées cachées dans le scoreboard.");
        } else {
            joueur.sendMessage(mineralcontest.prefixPrive + ChatColor.YELLOW + "Mode streamer désactivé : coordonnées visibles dans le scoreboard.");
        }

        // Rafraichir le HUD du joueur selon son état
        if (mcPlayer.getPartie() != null) {
            if (mcPlayer.getPartie().isReferee(joueur)) {
                // appliquer HUD arbitre
                PlayerHUDEvents.setPlayerRefereeHUD(mcPlayer);
            } else {
                PlayerHUDEvents.setPlayerInGameHUD(mcPlayer);
            }
        }

        return true;
    }

}
