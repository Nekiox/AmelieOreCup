package fr.nekiox.world_downloader.Items;

import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.world_downloader.Inventories.ConfirmationSuppressionInventory;
import fr.nekiox.world_downloader.Inventories.InventoryInterface;
import fr.nekiox.world_downloader.WorldDownloader;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ActionMapItem extends ItemInterface {


    private String nom_dossier_map = "";

    public ActionMapItem(String nom_dossier_map) {
        super();
        this.nom_dossier_map = nom_dossier_map;
    }


    @Override
    public Material getItemMaterial() {
        return Material.MAP;
    }

    @Override
    public String getNomInventaire() {
        return nom_dossier_map;
    }

    @Override
    public String getDescriptionInventaire() {
        return Lang.map_downloader_delete_description.toString();
    }

    @Override
    public void performClick(Player joueur) {

        for (InventoryInterface inventaire : WorldDownloader.getInstance().inventaires) {
            if (inventaire instanceof ConfirmationSuppressionInventory) {
                ((ConfirmationSuppressionInventory) inventaire).setNomDossier(nom_dossier_map);
                inventaire.openInventory(joueur);
                return;
            }
        }
    }

}
