package tv.circuitrcay.matebot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.String;


import javax.security.auth.login.LoginException;


import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;


import org.json.JSONObject;


import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.hooks.ListenerAdapter;
import tv.circuitrcay.matebot.commands.HelpCommand;



import tv.circuitrcay.matebot.commands.InfoCommand;
import tv.circuitrcay.matebot.commands.PingCommand;
import tv.circuitrcay.matebot.music.Music;
import tv.circuitrcay.matebot.twitch.CommandsTwitch;
import tv.circuitrcay.matebot.twitch.PingCommandTwitch;

public class MateBot extends ListenerAdapter {


    public static void main(String[] args) {
        try {
            String config = new String(Files.readAllBytes(Paths.get("config/bot.json")));
            JSONObject configJson = new JSONObject(config);
            String botToken = configJson.getString("botToken");
            String game = configJson.getString("game");
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(botToken)
                    .addEventListener(new InfoCommand())
                    .addEventListener(new Music())
                    .addEventListener(new PingCommand())
                    .addEventListener(new HelpCommand())
                    .setGame(Game.of(game))
                    .setBulkDeleteSplittingEnabled(false)
                    .buildAsync();
            Configuration configuration = new Configuration.Builder()
                    .setName("MateBotTwitch")
                    .addServer("irc.twitch.tv")
                    .setServerPassword("oauth:gm9inl0n60cr1u3w2n2rx8u7rsv71o")
                    .addAutoJoinChannel("#circuitrcay")
                    .addListener(new PingCommandTwitch())
                    .addListener(new CommandsTwitch())
                    .buildConfiguration();

            //Create our bot with the configuration
            PircBotX bot = new PircBotX(configuration);
            //Connect to the server
            bot.startBot();
        } catch (RateLimitedException e1) {
            e1.printStackTrace();
        } catch (LoginException e1) {
            e1.printStackTrace();
        } catch (IrcException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}