package fr.charlito33.skriptutils.httputils;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import fr.charlito33.skriptutils.httputils.effects.EffSendHTTPGetRequest;
import fr.charlito33.skriptutils.httputils.effects.EffSendHTTPPostRequest;
import fr.charlito33.skriptutils.httputils.expressions.ExprLastResponseCode;
import fr.charlito33.skriptutils.httputils.expressions.ExprLastResponseContent;

public class HTTPUtils {
    public static void register() {
        //Register Effects
        Skript.registerEffect(EffSendHTTPGetRequest.class, "send [an] [http] get request to %string%");
        Skript.registerEffect(EffSendHTTPPostRequest.class, "send [an] [http] post request to %string% with payload %string%");

        //Register Expressions
        Skript.registerExpression(ExprLastResponseCode.class, Integer.class, ExpressionType.PROPERTY, "[the] [last] [http] response code");
        Skript.registerExpression(ExprLastResponseContent.class, String.class, ExpressionType.PROPERTY, "[the] [last] [http] response content");
    }
}
