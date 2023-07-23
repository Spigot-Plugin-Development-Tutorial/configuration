package me.kodysimpson.configs;

import org.bukkit.plugin.java.JavaPlugin;

public final class Configs extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig(); //saves the default config.yml
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getCommand("changemessage").setExecutor(new ChangeMessageCommand(this));
    }

}
