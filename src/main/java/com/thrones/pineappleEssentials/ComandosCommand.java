package com.thrones.pineappleEssentials;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ComandosCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;

            p.sendMessage(ChatColor.GRAY+"-----------------------------------------------------");
            p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " ⚙ Comandos Disponíveis ⚙ ");
            p.sendMessage("");
            p.sendMessage(ChatColor.AQUA + "➤ " + ChatColor.BOLD + "/kit " + ChatColor.RESET + ChatColor.WHITE + "- Receba um kit inicial para te ajudar na sua jornada.");
            p.sendMessage(ChatColor.AQUA + "➤ " + ChatColor.BOLD + "/mortes " + ChatColor.RESET + ChatColor.WHITE + "- Veja quantas vezes cada jogador morreu.");
            p.sendMessage(ChatColor.AQUA + "➤ " + ChatColor.BOLD + "/diamante " + ChatColor.RESET + ChatColor.WHITE + "- Receba um diamante "
                    + ChatColor.RED + ChatColor.BOLD + "(1x por dia)");
            p.sendMessage(ChatColor.AQUA + "➤ " + ChatColor.BOLD + "/loja " + ChatColor.RESET + ChatColor.WHITE + "- "
                    + ChatColor.YELLOW + ChatColor.BOLD + "EM BREVE!");
            p.sendMessage(ChatColor.GRAY+"-----------------------------------------------------");
        }
        return false;
    }
}
