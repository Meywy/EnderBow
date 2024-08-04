package me.meywy.enderBow;

import me.meywy.enderBow.commands.GetBowCMD;
import me.meywy.enderBow.listeners.ShootBow;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnderBow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("EnderBow Loaded!");
        getCommand("getebow").setExecutor(new GetBowCMD());
        Bukkit.getPluginManager().registerEvents(new ShootBow(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("EnderBow unLoaded!");
    }
}
