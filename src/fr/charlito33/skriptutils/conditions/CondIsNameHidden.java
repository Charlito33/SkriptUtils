package fr.charlito33.skriptutils.conditions;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import fr.charlito33.skriptutils.SkriptUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class CondIsNameHidden extends Condition {
    private Expression<Player> player;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, SkriptParser.ParseResult pr) {
        player = (Expression<Player>) expr[0];

        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "%players%'s name is hidden";
    }

    @Override
    public boolean check(Event e) {
        boolean hidden = true;

        for (Player lPlayer : player.getAll(e)) {
            if (!SkriptUtils.scoreboard.getTeam("nameHidden").hasEntry(lPlayer.getName())) {
                hidden = false;
                break;
            }
        }

        return hidden;
    }
}
