package fr.dreyfox.foxessentials.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TpCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("fox.tp") && !sender.hasPermission("fox.admin")) {
            sender.sendMessage("§cErreur: Permission manquante.");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("§cErreur: Faites /" + label + " <joueur> <autreJoueur>");
            return true;
        }

        if (args.length == 1) {
            if (!(sender instanceof Player)) { sender.sendMessage("Players only."); return true; }
            Player p = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) { p.sendMessage("§cErreur: Joueur introuvable " + args[0]); return true; }
            p.teleport(target.getLocation());
            p.sendMessage("§7TP vers §e" + target.getName());
            return true;
        }

        Player a = Bukkit.getPlayerExact(args[0]);
        Player b = Bukkit.getPlayerExact(args[1]);
        if (a == null || b == null) { sender.sendMessage("§cErreur: Joueur introuvable."); return true; }
        a.teleport(b.getLocation());
        sender.sendMessage("§7TP §e" + a.getName() + " §7vers §e" + b.getName());
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> names = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) names.add(p.getName());
        if (args.length == 1) return names;
        if (args.length == 2) return names;
        return Collections.emptyList();
    }

}
