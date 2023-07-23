package me.kodysimpson.configs;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class JoinListener implements Listener {

    private final Configs plugin;

    public JoinListener(Configs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        String joinMessage = this.plugin.getConfig().getString("join-message");
        if (joinMessage != null){
            //replace the player thing
            joinMessage = joinMessage.replace("%player%", e.getPlayer().getDisplayName());
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));
        }

        boolean feedPlayer = this.plugin.getConfig().getBoolean("feed-player");
        if (feedPlayer){
            e.getPlayer().setFoodLevel(20);
        }

        List<String> favFoods = this.plugin.getConfig().getStringList("foods");
        e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYour favorite foods are:"));
        for (String food : favFoods){
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&a- " + food));
        }

    }

}
