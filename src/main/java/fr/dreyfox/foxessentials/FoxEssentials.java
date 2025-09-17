package fr.dreyfox.foxessentials;

import fr.dreyfox.foxessentials.cmd.*;
import fr.dreyfox.foxessentials.util.Text;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class FoxEssentials extends JavaPlugin {

    private static FoxEssentials instance;

    public static FoxEssentials get() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("connexion").setExecutor(new ConnexionCommand());
        getCommand("creatif").setExecutor(new CreativeCommand());
        getCommand("spec").setExecutor(new SpecCommand());
        TpCommand tp = new TpCommand();
        getCommand("tp").setExecutor(tp);
        getCommand("tp").setTabCompleter(tp);

        Bukkit.getPluginManager().registerEvents(new EssentialsListener(), this);
    }

    public boolean isSpawnSet() {
        FileConfiguration c = getConfig();
        return c.isString("spawn.world") && !c.getString("spawn.world", "").isEmpty();
    }

    public Location getSpawn() {
        FileConfiguration c = getConfig();
        if (!isSpawnSet()) return null;
        World w = Bukkit.getWorld(c.getString("spawn.world"));
        if (w == null) return null;
        double x = c.getDouble("spawn.x");
        double y = c.getDouble("spawn.y");
        double z = c.getDouble("spawn.z");
        float yaw = (float) c.getDouble("spawn.yaw");
        float pitch = (float) c.getDouble("spawn.pitch");
        return new Location(w, x, y, z, yaw, pitch);
    }

    public void setSpawn(Location loc) {
        FileConfiguration c = getConfig();
        c.set("spawn.world", loc.getWorld().getName());
        c.set("spawn.x", loc.getX());
        c.set("spawn.y", loc.getY());
        c.set("spawn.z", loc.getZ());
        c.set("spawn.yaw", loc.getYaw());
        c.set("spawn.pitch", loc.getPitch());
        saveConfig();
    }

    public String motd() {
        return Text.cc(getConfig().getString("motd", "&6FoxEssentials &7- &fBienvenue !"));
    }
}