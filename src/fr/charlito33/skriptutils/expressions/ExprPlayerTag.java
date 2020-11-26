package fr.charlito33.skriptutils.expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.bringholm.nametagchanger.NameTagChanger;
import fr.charlito33.skriptutils.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class ExprPlayerTag extends SimpleExpression<String> {
    private Expression<Player> player;

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        player = (Expression<Player>) expr[0];

        return true;
    }

    @Override
    public String toString(Event e, boolean b) {
        return "tag of player";
    }

    @Override
    @Nullable
    protected String[] get(Event e) {
        if (Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {
            String tag = NameTagChanger.INSTANCE.getChangedName(player.getSingle(e));

            if (tag == null) {
                tag = player.getSingle(e).getName();
            }

            return new String[]{tag};
        } else {
            Logger.info(ChatColor.RED + "You cannot use '" + this.toString(e, false) + "' because you don't have ProtocolLib installed/enabled !");

            return new String[]{player.getSingle(e).getName()};
        }
    }
}
