package fr.charlito33.skriptutils.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import fr.charlito33.skriptutils.SkriptUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class EffShowPlayerTag extends Effect {
    private Expression<Player> players;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, SkriptParser.ParseResult paramParseResult) {
        players = (Expression<Player>) expr[0];

        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
        return "show %players%'s tag";
    }

    @Override
    protected void execute(Event e) {
        for (Player lPlayer : players.getAll(e)) {
            if (SkriptUtils.scoreboard.getTeam("nameHidden").hasEntry(lPlayer.getName())) {
                SkriptUtils.scoreboard.getTeam("nameHidden").removeEntry(lPlayer.getName());
            }
        }
    }
}
