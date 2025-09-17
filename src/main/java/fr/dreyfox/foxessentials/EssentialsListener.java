package fr.dreyfox.foxessentials;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class EssentialsListener implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            Location spawn = FoxEssentials.get().getSpawn();
            if (spawn != null) {
                Bukkit.getScheduler().runTask(FoxEssentials.get(), () -> p.teleport(spawn));
            }
        }
    }

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        e.setMotd(FoxEssentials.get().motd());
    }
}