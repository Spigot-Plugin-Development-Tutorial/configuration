package me.kodysimpson.configs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChangeMessageCommand implements CommandExecutor {

    private final Configs plugin;

    public ChangeMessageCommand(Configs plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length > 0){
            String newMessage = args[0];
            this.plugin.getConfig().set("join-message", newMessage);
            this.plugin.saveConfig();

            sender.sendMessage("Join message changed to: " + ChatColor.translateAlternateColorCodes('&', newMessage));
        }else{
            sender.sendMessage("You must provide a new message!");
        }

        return true;
    }
}
