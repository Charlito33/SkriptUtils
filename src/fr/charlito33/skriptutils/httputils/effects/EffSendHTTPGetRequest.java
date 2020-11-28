package fr.charlito33.skriptutils.httputils.effects;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import fr.charlito33.skriptutils.httputils.utils.HTTPRequestSaver;
import fr.charlito33.skriptutils.utils.Logger;
import org.bukkit.ChatColor;
import org.bukkit.event.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class EffSendHTTPGetRequest extends Effect {
    private Expression<String> url;

    @Override
    protected void execute(Event e) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://charlito33.fr.nf/api/get-content-from-url.php?type=GET&url=" + url.getSingle(e)).openConnection();

            connection.setRequestMethod("GET"); //Default is : GET -> Optionnal

            //connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");
            //connection.setRequestProperty("Content-Type", "application/json");
            //connection.setInstanceFollowRedirects(true);



            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                HTTPRequestSaver.saveResponseCode(responseCode);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = bufferedReader.readLine()) != null) {
                    response.append(inputLine);
                }

                HTTPRequestSaver.saveResponseContent(response.toString());

                bufferedReader.close();
            } else {
                Logger.info(ChatColor.RED + "Response code unexpected : " + responseCode + ", expected : 200");
            }
        } catch (MalformedURLException malformedURLException) {
            Logger.info(ChatColor.RED + "Bad Url : " + url.getSingle(e) + " (maybe try add \"http://\" ?).");
        } catch (IOException ioException) {
            Logger.info(ChatColor.RED + "IOException, can't connect to \"" + url.getSingle(e) + "\".");
        }

    }

    @Override
    public String toString(Event e, boolean b) {
        return "send an http get request to %string%";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        url = (Expression<String>) expr[0];

        return true;
    }
}
