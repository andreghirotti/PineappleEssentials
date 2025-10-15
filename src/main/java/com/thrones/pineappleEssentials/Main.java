package com.thrones.pineappleEssentials;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    //TODO (✅)
    //Adicionar /kit ✅
    //Adicionar /mortes -> Mostra a lista dos jogadores do servidor e o numero de mortes ✅
    //Adicionar um "Clique aqui para mandar um OI" na mensagem de quando alguem entra
    //Adicionar /comandos ✅
    //Consertar X players online. For loop onPlayerJoin onPlayerQuit pra atualizar pra todos os jogadores online ✅

    @Override
    public void onEnable() {
        System.out.println("PINEAPPLE ESSENTIALS HAS SUCCESSFULLY STARTED");
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new com.thrones.pineappleEssentials.EventHandler(), this);
        getCommand("kit").setExecutor(new KitCommand());
        getCommand("comandos").setExecutor(new ComandosCommand());
        getCommand("mortes").setExecutor(new DeathsCommand());
        getCommand("diamante").setExecutor(new DiamondCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}
