package fr.dreyfox.foxessentials.cmd;

import fr.dreyfox.foxessentials.FoxEssentials;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage("Players only."); return true; }
        Player p = (Player) sender;
        Location spawn = FoxEssentials.get().getSpawn();
        if (spawn == null) { p.sendMessage("§cErreur: Aucun spawn défini."); return true; }
        p.teleport(spawn);
        p.sendMessage("§7Téléportation au §6spawn§7.");
        return true;
    }
}