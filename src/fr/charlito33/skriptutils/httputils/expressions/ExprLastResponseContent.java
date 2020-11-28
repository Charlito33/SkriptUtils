package fr.charlito33.skriptutils.httputils.expressions;


import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import fr.charlito33.skriptutils.httputils.utils.HTTPRequestSaver;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class ExprLastResponseContent extends SimpleExpression<String> {
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
        return true;
    }

    @Override
    public String toString(Event e, boolean b) {
        return "last http response content";
    }

    @Override
    @Nullable
    protected String[] get(Event e) {
        return new String[]{HTTPRequestSaver.getResponseContent()};
    }
}
