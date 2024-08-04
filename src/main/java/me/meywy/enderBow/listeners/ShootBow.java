package me.meywy.enderBow.listeners;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class ShootBow implements Listener {

    @EventHandler
    public void onShootBow (EntityShootBowEvent e) {
        var entity = e.getEntity();
        var bow = e.getBow();

        // Checks if Bow Shooter is Player
        if(!(entity instanceof Player p)) return;

        // Null checks bow
        if(bow == null) return;

        // Checks if bow has ItemMeta
        if(!(bow.hasItemMeta())) return;

        // Checks for ModelData id
        if(bow.getItemMeta().getCustomModelData() != 11111) {
            e.setCancelled(true);
        }

        e.setCancelled(true);
        entity.launchProjectile(EnderPearl.class, e.getProjectile().getVelocity());

    }

}
