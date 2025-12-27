package fr.nekiox.groups.Commands.Groupe;

import fr.nekiox.groups.Commands.CommandTemplate;
import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuitterGroupe extends CommandTemplate {

    public QuitterGroupe() {
        super();
        this.accessCommande.add(PLAYER_COMMAND);
        this.accessCommande.add(GROUP_REQUIRED);
        accessCommande.add(REQUIRE_COMMUNITY_VERSION);
        accessCommande.add(GAME_NOT_STARTED);

    }

    @Override
    public boolean performCommand(CommandSender commandSender, String command, String[] args) {
        Player joueur = (Player) commandSender;
        Groupe playerGroup = mineralcontest.getPlayerGroupe(joueur);
        playerGroup.retirerJoueur(joueur);
        return false;
    }

    @Override
    public String getCommand() {
        return "quittergroupe";
    }


    @Override
    public String getDescription() {
        return "Permet de quitter son groupe";
    }

    @Override
    public String getPermissionRequise() {
        return null;
    }
}
