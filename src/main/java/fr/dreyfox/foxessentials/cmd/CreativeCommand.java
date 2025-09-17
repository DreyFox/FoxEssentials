package fr.dreyfox.foxessentials.cmd;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreativeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { sender.sendMessage("Players only."); return true; }
        Player p = (Player) sender;
        if (!p.hasPermission("fox.creatif") && !p.hasPermission("fox.admin")) {
            p.sendMessage("§cErreur: Permission manquante.");
            return true;
        }
        p.setGameMode(GameMode.CREATIVE);
        p.sendMessage("§7Nouveau mode de jeu: §6Créatif");
        return true;
    }
}