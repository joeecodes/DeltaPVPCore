package com.hypews.deltapvp.commands;

import com.hypews.deltapvp.DeltaPVP;
import com.hypews.deltapvp.Messages;
import com.hypews.deltapvp.annotations.Permission;
import com.hypews.deltapvp.data.DataManager;
import com.hypews.deltapvp.data.LangManager;
import com.hypews.deltapvp.ui.CoreCommand;
import com.hypews.deltapvp.utils.MSG;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Permission("deltapvp.command.root")
public class CommandDeltaPVP extends CoreCommand {
    public CommandDeltaPVP() {
        super("deltapvp");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player executor = (Player) sender;
        String options = args[0];
        if (args.length == 1) {
            switch (options.toLowerCase()) {
                case "reload": {
                    new MSG(Messages.CONFIG_RELOAD).send(sender);
                    reloadConfigs();
                }
            }
        }
        args(sender);
    }

    private void reloadConfigs() {
        LangManager.dataReload();
        DataManager.dataReload();
        DeltaPVP.getInstance().reloadConfig();
    }

    private void args(CommandSender s) {
        new MSG("DeltaPVP Command Args").send(s);
        new MSG("&5/deltapvp reload &d- &5Reloads the configs").send(s);
    }
}
