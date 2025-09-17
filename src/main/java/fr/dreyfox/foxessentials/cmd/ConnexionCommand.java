package fr.dreyfox.foxessentials.cmd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConnexionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("fox.connexion") && !sender.hasPermission("fox.admin")) {
            sender.sendMessage("§cErreur: Permission manquante.");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage("§cErreur: Utilisation: /" + label + " on|off|add|remove [pseudo]");
            return true;
        }
        String sub = args[0].toLowerCase();
        switch (sub) {
            case "on":
                Bukkit.setWhitelist(true);
                sender.sendMessage("§7Vous avez §aactivée §7la whitelist.");
                return true;
            case "off":
                Bukkit.setWhitelist(false);
                sender.sendMessage("§7Vous avez §cdésactivée §7la whitelist.");
                return true;
            case "add":
                if (args.length < 2) { sender.sendMessage("§cErreur: Veuillez précisez un pseudo."); return true; }
                OfflinePlayer add = Bukkit.getOfflinePlayer(args[1]);
                add.setWhitelisted(true);
                sender.sendMessage("§7Vous avez §aajouté §7à la whitelist: §6" + (add.getName() == null ? args[1] : add.getName()));
                return true;
            case "remove":
                if (args.length < 2) { sender.sendMessage("§cErreur: Veuillez précisez un pseudo."); return true; }
                OfflinePlayer rem = Bukkit.getOfflinePlayer(args[1]);
                rem.setWhitelisted(false);
                sender.sendMessage("§7Vous avez §cretiré §7de la whitelist: §6" + (rem.getName() == null ? args[1] : rem.getName()));
                return true;
            default:
                sender.sendMessage("§cErreur: Utilisation: /" + label + " on|off|add|remove [pseudo]");
                return true;
        }
    }
}