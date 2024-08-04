package me.meywy.enderBow.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetBowCMD implements CommandExecutor {

    private static final String Name = ChatColor.GRAY  + "[" + ChatColor.DARK_PURPLE + "Ender" + ChatColor.BLACK + "Bow" + ChatColor.GRAY + "] ";
    public static String getName() { return Name; }


    @Override
    public boolean onCommand(CommandSender sen, Command command, String s, String[] strings) {

        // Checks if sender of command is player
        if(!(sen instanceof Player p)) {
            sen.sendMessage(Name + ChatColor.RED + "You must be a player to use this command!");
            return true;
        }

        // Checks for player permissions
        if (!(p.hasPermission("enderbow.give"))) {
            sen.sendMessage(Name + ChatColor.RED + "Sorry, you can't do that!");
            return true;
        }

        // Custom bow
        ItemStack eBow = new ItemStack(Material.BOW);
        ItemMeta eBowMeta = (ItemMeta) eBow.getItemMeta();
        eBowMeta.setDisplayName(ChatColor.DARK_PURPLE + "Ender " + ChatColor.BLACK + "Bow" );
        eBowMeta.setCustomModelData(11111);
        eBow.setItemMeta(eBowMeta);

        p.getInventory().addItem(eBow);

        return true;
    }
}
