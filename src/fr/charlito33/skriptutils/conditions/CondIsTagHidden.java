package fr.charlito33.skriptutils.conditions;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import fr.charlito33.skriptutils.SkriptUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class CondIsTagHidden extends Condition {
    private Expression<Player> players;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, SkriptParser.ParseResult pr) {
        players = (Expression<Player>) expr[0];

        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "%players%'s tag is hidden";
    }

    @Override
    public boolean check(Event e) {
        boolean hidden = true;

        for (Player lPlayer : players.getAll(e)) {
            if (!SkriptUtils.scoreboard.getTeam("nameHidden").hasEntry(lPlayer.getName())) {
                hidden = false;
                break;
            }
        }

        return hidden;
    }
}
