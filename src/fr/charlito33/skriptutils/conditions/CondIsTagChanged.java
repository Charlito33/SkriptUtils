package fr.charlito33.skriptutils.conditions;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.bringholm.nametagchanger.NameTagChanger;
import fr.charlito33.skriptutils.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class CondIsTagChanged extends Condition {
    private Expression<Player> players;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, SkriptParser.ParseResult pr) {
        players = (Expression<Player>) expr[0];

        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "%players%'s tag changed";
    }

    @Override
    public boolean check(Event e) {
        if (Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {
            boolean changed = true;

            for (Player lPlayer : players.getAll(e)) {
                if (NameTagChanger.INSTANCE.getChangedName(lPlayer) == null) {
                    changed = false;
                }
            }

            return changed;
        } else {
            Logger.info(ChatColor.RED + "You cannot use '" + this.toString(e, false) + "' because you don't have ProtocolLib installed/enabled !");

            return false;
        }
    }
}
