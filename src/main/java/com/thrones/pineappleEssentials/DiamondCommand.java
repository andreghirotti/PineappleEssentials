package com.thrones.pineappleEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DiamondCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            p.sendMessage(ChatColor.GRAY+"Achou mesmo que ganharia um "+ChatColor.AQUA+ChatColor.BOLD+"diamante"+ ChatColor.RESET + ChatColor.GRAY + " de graça?");
        }
        return false;
    }
}
