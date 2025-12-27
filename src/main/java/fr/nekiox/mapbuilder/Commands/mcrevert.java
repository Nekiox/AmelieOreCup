package fr.nekiox.mapbuilder.Commands;

import fr.nekiox.groups.Commands.CommandTemplate;
import fr.nekiox.mapbuilder.MapBuilder;
import fr.nekiox.mineral.Utils.BlockSaver;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Stack;

public class mcrevert extends CommandTemplate {
    @Override
    public String getCommand() {
        return "mcrevert";
    }


    @Override
    public String getDescription() {
        return "Permet";
    }

    @Override
    public String getPermissionRequise() {
        return null;
    }

    @Override
    public boolean performCommand(CommandSender commandSender, String command, String[] args) {
        if (!MapBuilder.modifications.empty()) {
            Stack<BlockSaver> dernierPose = MapBuilder.modifications.pop();
            for (BlockSaver block : dernierPose)
                block.applyMethod();
            commandSender.sendMessage(mineralcontest.prefixPrive + ChatColor.GREEN + "Revert done!");
        } else {
            commandSender.sendMessage(mineralcontest.prefixPrive + ChatColor.RED + "Nothing to revert!");

        }
        return false;
    }
}
