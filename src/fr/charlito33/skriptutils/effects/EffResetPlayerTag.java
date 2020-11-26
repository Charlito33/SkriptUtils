package fr.charlito33.skriptutils.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.bringholm.nametagchanger.NameTagChanger;
import fr.charlito33.skriptutils.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffResetPlayerTag extends Effect {

    private Expression<Player> player;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, SkriptParser.ParseResult pr) {
        player = (Expression<Player>) expr[0];

        return true;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "reset %players%'s tag";
    }

    @Override
    protected void execute(Event e) {
        if (Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {
            for (Player lPlayer : player.getAll(e)) {
                NameTagChanger.INSTANCE.resetPlayerName(lPlayer);
            }
        } else {
            Logger.info(ChatColor.RED + "You cannot use '" + this.toString(e, false) + "' because you don't have ProtocolLib installed/enabled !");
        }
    }
}
