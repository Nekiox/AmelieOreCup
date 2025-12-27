package fr.nekiox.challenges.Availables;

import fr.nekiox.challenges.ChallengeManager;
import fr.nekiox.challenges.Rewards.AbstractReward;
import fr.nekiox.challenges.Rewards.SingleArticleReward;
import fr.nekiox.mineral.Core.MCPlayer;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PoserBlockTest extends AbstractChallenge {

    public PoserBlockTest(ChallengeManager manager) {
        super(manager);
    }

    @Override
    public String getNom() {
        return "vive l'écologie";
    }

    @Override
    public String getObjectifTexte() {
        return "Posez un bloc de bouse!";
    }

    @Override
    public AbstractReward getReward() {
        return new SingleArticleReward(new ItemStack(Material.DIAMOND_SWORD));
    }


    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {

        if(event.isCancelled()) return;

        MCPlayer mcPlayer = mineralcontest.plugin.getMCPlayer(event.getPlayer());
        if(mcPlayer == null) return;

        if(getManager().doesPlayerHaveThisAchievement(mcPlayer, this)) {
            if(event.getBlock().getType() == Material.DIRT) {
                getManager().playerDidAchievement(mcPlayer, this);
            }
        }
    }
}
