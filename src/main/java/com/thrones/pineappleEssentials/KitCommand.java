package com.thrones.pineappleEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player){
            Player p = (Player) commandSender;
            Inventory inv = p.getInventory();
            if (!(p.getScoreboardTags().contains("starter_kit_used"))) {
                if (inv.isEmpty()) {
                    inv.addItem(ItemStack.of(Material.STONE_SWORD));
                    inv.addItem(ItemStack.of(Material.STONE_PICKAXE));
                    inv.addItem(ItemStack.of(Material.STONE_AXE));
                    p.sendMessage(ChatColor.GREEN + "Parabéns, você resgatou seu " + ChatColor.WHITE + ChatColor.BOLD + "Kit Inicial" + ChatColor.RESET + ChatColor.GREEN + "!");
                    p.addScoreboardTag("starter_kit_used");
                    p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.5f, 1.0f);

                } else p.sendMessage(ChatColor.RED + "Por favor, esvazie seu inventário primeiro.");
            } else p.sendMessage(ChatColor.RED + "Você já resgatou seu "+ChatColor.WHITE+ChatColor.BOLD+"Kit Inicial"+ChatColor.RESET+ChatColor.RED+".");
        }
        return false;
    }
}
