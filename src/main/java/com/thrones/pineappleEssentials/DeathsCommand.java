package com.thrones.pineappleEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeathsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (sender instanceof Player) {

        // Cria uma lista com jogadores e suas mortes
        List<Map.Entry<String, Integer>> deathList = new ArrayList<>();

        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            if (player.getName() == null) continue; // Evita players nulos
            int deaths = player.getStatistic(Statistic.DEATHS);
            if (deaths > 0) {
                deathList.add(new AbstractMap.SimpleEntry<>(player.getName(), deaths));
            }
        }

        // Ordena em ordem decrescente
        deathList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            sender.sendMessage(ChatColor.GRAY+"-----------------------------------------------------");
            sender.sendMessage("           ☠" + ChatColor.GREEN + ChatColor.BOLD +" Ranking de mortes dos jogadores "+ChatColor.RESET+"☠");
            sender.sendMessage("");
            int rank = 1;
            for (Map.Entry<String, Integer> entry : deathList) {

                sender.sendMessage("" + ChatColor.GOLD + ChatColor.BOLD + rank + ". " + ChatColor.RESET + ChatColor.BOLD + entry.getKey() + ":" + ChatColor.RESET + ChatColor.GRAY + " morreu " + ChatColor.RED + ChatColor.BOLD + entry.getValue() +
                        ChatColor.RESET + ChatColor.GRAY + " vezes");
                rank++;
                if (rank > 10) break; // Top 10 apenas
            }

            if (deathList.isEmpty()) {
                sender.sendMessage("" + ChatColor.BOLD + ChatColor.GRAY + "Ninguém morreu ainda... que milagre!");
            }
        }


        return false;
    }
}
