package fr.dreyfox.foxessentials.cmd;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("fox.night") && !sender.hasPermission("fox.admin")) {
            sender.sendMessage("§cErreur: Permission manquante.");
            return true;
        }
        World w = (sender instanceof Player) ? ((Player)sender).getWorld() : Bukkit.getWorlds().get(0);
        if (w == null) { sender.sendMessage("§cErreur: Monde introuvable."); return true; }
        w.setTime(14000L);
        sender.sendMessage("§7Nuit définie dans §6" + w.getName());
        return true;
    }
}