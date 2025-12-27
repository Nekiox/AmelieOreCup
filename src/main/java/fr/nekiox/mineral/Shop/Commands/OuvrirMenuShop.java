package fr.nekiox.mineral.Shop.Commands;

import fr.nekiox.groups.Commands.CommandTemplate;
import fr.nekiox.groups.Core.Groupe;
import fr.nekiox.mineral.Shop.NPCs.BonusSeller;
import fr.nekiox.mineral.Shop.ShopManager;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OuvrirMenuShop extends CommandTemplate {

    public OuvrirMenuShop() {
        accessCommande.add(PLAYER_COMMAND);
        accessCommande.add(GROUP_REQUIRED);
    }

    @Override
    public String getCommand() {
        return "mcshop";
    }

    @Override
    public String getDescription() {
        return "Ouvre le menu du shop";
    }

    @Override
    public String getPermissionRequise() {
        return null;
    }

    @Override
    public boolean performCommand(CommandSender commandSender, String command, String[] args) {
        Player joueur = (Player) commandSender;
        Groupe groupe = mineralcontest.getPlayerGroupe(joueur);

        ShopManager shopManager = groupe.getGame().getShopManager();

        // On ajoute un nouveau vendeur
        BonusSeller vendeur = ShopManager.creerVendeur(joueur.getLocation());
        shopManager.ajouterVendeur(vendeur);

        vendeur.spawn();

        joueur.openInventory(vendeur.getInventory());

        return false;
    }
}
