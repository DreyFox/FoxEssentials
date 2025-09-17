package fr.dreyfox.foxessentials.cmd;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpecCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage("Players only."); return true; }
        Player p = (Player) sender;
        if (!p.hasPermission("fox.spec") && !p.hasPermission("fox.admin")) {
            p.sendMessage("§cErreur: Permission manquante.");
            return true;
        }
        p.setGameMode(GameMode.SPECTATOR);
        p.sendMessage("§7Nouveau mode de jeu: §6Spectateur");
        return true;
    }
}
