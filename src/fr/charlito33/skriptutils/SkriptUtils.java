package fr.charlito33.skriptutils;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import com.bringholm.nametagchanger.NameTagChanger;
import fr.charlito33.skriptutils.conditions.CondIsTagHidden;
import fr.charlito33.skriptutils.conditions.CondIsTagChanged;
import fr.charlito33.skriptutils.effects.EffChangePlayerTag;
import fr.charlito33.skriptutils.effects.EffHidePlayerTag;
import fr.charlito33.skriptutils.effects.EffResetPlayerTag;
import fr.charlito33.skriptutils.effects.EffShowPlayerTag;
import fr.charlito33.skriptutils.expressions.ExprPlayerTag;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class SkriptUtils extends JavaPlugin {
    public static Scoreboard scoreboard;

    @Override
    public void onEnable() {
        //Register Skript Addon
        Skript.registerAddon(this);

        //Register Effects
        Skript.registerEffect(EffHidePlayerTag.class, "hide [the] %players%['s] (tag|name)[s]", "hide [the] (tag|name)[s] of %players%");
        Skript.registerEffect(EffShowPlayerTag.class, "show [the] %players%['s] (tag|name)[s]", "show [the] (tag|name)[s] of %players%");
        Skript.registerEffect(EffChangePlayerTag.class, "set [the] (tag|name)[s] of %players% to %string%", "set [the] %players%['s] (tag|name)[s] to %string%");
        Skript.registerEffect(EffResetPlayerTag.class, "reset [the] (tag|name)[s] of %players%", "reset [the] %players%['s] (tag|name)[s]");

        //Register Conditions
        Skript.registerCondition(CondIsTagChanged.class, "[the] %players%['s] (tag|name)[s] (is|are) visible[s]", "[the] (tag|name)[s] of %players% (is|are) visible[s]");
        Skript.registerCondition(CondIsTagHidden.class, "[the] %players%['s] (tag|name)[s] (is|are) hidden[s]", "[the] (tag|name)[s] of %players% (is|are) hidden[s]");
        Skript.registerCondition(CondIsTagChanged.class, "[the] %players%['s] (tag|name)[s] (is|are) changed", "[the] (tag|name)[s] of %players% (is|are) changed");

        //Register Expressions
        Skript.registerExpression(ExprPlayerTag.class, String.class, ExpressionType.PROPERTY, "[the] %player%['s] (tag|name)", "[the] (tag|name) of %player%");

        //Register NameTagChanger
        if (!NameTagChanger.INSTANCE.isEnabled()) {
            NameTagChanger.INSTANCE.enable();
        }

        //Get Scoreboard for hide names
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        //If Scoreboard not exists, register new one
        if (scoreboard.getTeam("nameHidden") == null) {
            Team nameHiddenTeam = scoreboard.registerNewTeam("nameHidden");
            nameHiddenTeam.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
        }
    }

    @Override
    public void onDisable() {
        //Unregister NameTagChanger
        if (NameTagChanger.INSTANCE.isEnabled()) {
            NameTagChanger.INSTANCE.disable();
        }
    }
}
