package com.thrones.pineappleEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static org.bukkit.Bukkit.getServer;

public class EventHandler implements Listener {

    @org.bukkit.event.EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String playerName = e.getPlayer().getName();
        String message = e.getMessage();

        e.setFormat(ChatColor.GRAY + "[" + ChatColor.GREEN +ChatColor.BOLD+ playerName +ChatColor.RESET+ ChatColor.GRAY + "] "
                + ChatColor.WHITE + ": " + message);
    }

    @org.bukkit.event.EventHandler
    public void onPlayerJoins(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(""+ ChatColor.WHITE + ChatColor.BOLD + e.getPlayer().getName() + ChatColor.RESET+ChatColor.GREEN + " entrou no servidor!");
        p.playSound(p.getLocation(), "entity.experience_orb.pickup", 5.0f, 1.2f);
        p.spawnParticle(
                Particle.HAPPY_VILLAGER,
                p.getLocation().add(0, 1, 0),
                30, //  Count
                0.5, 1.0, 0.5, // Spread
                0.01); // Speed


        //Welcomes the Player
        if (!(p.hasPlayedBefore()) || p.getName().equals("ImThrones")) {
            p.sendMessage(ChatColor.GRAY+"-----------------------------------------------------");
            p.sendMessage(ChatColor.GREEN + "Seja bem-vindo(a), " + ChatColor.AQUA + ChatColor.BOLD + ChatColor.ITALIC + p.getName() +
                    ChatColor.RESET + ChatColor.GREEN + ", ao " +
                    ChatColor.GOLD + ChatColor.BOLD + "Pineapple Empire "+ChatColor.WHITE+"SMP" +
                    ChatColor.RESET + ChatColor.GREEN + ",");
            p.sendMessage(ChatColor.GREEN + "o melhor servidor de " +ChatColor.WHITE+
                    "SMP "+ChatColor.GREEN+"de "+ChatColor.WHITE+ChatColor.BOLD+"Barão Geraldo"+ChatColor.RESET+ChatColor.GREEN+" e região!");
            p.sendMessage(ChatColor.GRAY+"-----------------------------------------------------");
            p.sendMessage(ChatColor.GREEN + "Para mais informações digite" + ChatColor.WHITE + " /comandos" + ChatColor.GREEN + "!");

        }

        updateTabListForAll("join");

    }


    @org.bukkit.event.EventHandler
    public void onPlayerLeaves(PlayerQuitEvent e){
        e.setQuitMessage(""+ ChatColor.WHITE + ChatColor.BOLD + e.getPlayer().getName() + ChatColor.RESET+ChatColor.GREEN + " saiu do servidor!");
        updateTabListForAll("quit");
    }

    public void updateTabListForAll(String qj) {
        int online = getServer().getOnlinePlayers().size();
        final String header = "" + ChatColor.GREEN + ChatColor.BOLD + "Pineapple Empire";
        String footer;

        if (qj.equals("quit")) online--; // Checks if the class was called from an onPlayerLeaves event.
        // If it was, decrease the online variable by one since the game registers the online players size before player quits.


        if (online > 1){
            footer = "" + ChatColor.GOLD + ChatColor.BOLD+ online +
                    ChatColor.RESET + " jogadores online";
        } else {
            footer = "" + ChatColor.GOLD + ChatColor.BOLD+ online +
                    ChatColor.RESET + " jogador online";
        }

        for (Player player : getServer().getOnlinePlayers()){
            player.setPlayerListHeaderFooter(header, footer);
        }
    }


}
