package fr.nekiox.custom_events;

import fr.nekiox.mineral.Core.Coffre.AutomatedChestAnimation;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class MCAutomatedChestTimeOverEvent extends MCEvent {


    private AutomatedChestAnimation automatedChest;

    private Player openingPlayer;


    public MCAutomatedChestTimeOverEvent(AutomatedChestAnimation automatedChestAnimation, Player openingPlayer) {
        this.automatedChest = automatedChestAnimation;
        this.openingPlayer = openingPlayer;
    }

    public AutomatedChestAnimation getAutomatedChest() {
        return automatedChest;
    }

}
