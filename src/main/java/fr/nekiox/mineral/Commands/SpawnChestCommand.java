package fr.nekiox.mineral.Commands;

import fr.nekiox.custom_events.MCArenaChestSpawnEvent;
import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.mineral.Core.Game.Game;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(Lang.error_command_can_only_be_used_in_game.toString());
            return false;
        }

        Player player = (Player) commandSender;
        if (mineralcontest.isInAMineralContestWorld(player)) {
            Game partie = mineralcontest.getPlayerGame(player);
            if (partie == null) {
                commandSender.sendMessage(mineralcontest.prefixErreur + Lang.error_command_can_only_be_used_in_game.toString());
                return false;
            }

            Groupe playerGroupe = partie.groupe;


            if (command.getName().equalsIgnoreCase("spawnchest")) {
                if (playerGroupe.isAdmin(player)) {
                    if (partie.isGameStarted()) {
                        try {
                            partie.getArene().getCoffre().spawn();

                            MCArenaChestSpawnEvent mcArenaChestSpawnEvent = new MCArenaChestSpawnEvent(partie);
                            Bukkit.getPluginManager().callEvent(mcArenaChestSpawnEvent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        commandSender.sendMessage(mineralcontest.prefixErreur + Lang.error_command_only_when_game_is_started.toString());
                        return false;
                    }
                }

                return false;
            }
        }


        return false;
    }
}
