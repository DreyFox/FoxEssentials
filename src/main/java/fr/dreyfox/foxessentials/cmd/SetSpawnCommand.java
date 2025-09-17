package fr.dreyfox.foxessentials.cmd;

import fr.dreyfox.foxessentials.FoxEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage("Players only."); return true; }
        Player p = (Player) sender;
        if (!p.hasPermission("fox.setspawn") && !p.hasPermission("fox.admin")) {
            p.sendMessage("§cErreur: Permission manquante.");
            return true;
        }
        FoxEssentials.get().setSpawn(p.getLocation());
        p.sendMessage("§aSpawn défini sur votre position !");
        return true;
    }
}