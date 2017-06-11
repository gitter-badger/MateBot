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


import tv.circuitrcay.matebot.commands.InfoCommand;
import tv.circuitrcay.matebot.music.Music;


public class MateBot {
	
	
	public static void main(String[] args) throws Exception {
		try {
			String config = new String(Files.readAllBytes(Paths.get("config/bot.json")));
			JSONObject configJson = new JSONObject(config);
			String botToken = configJson.getString("botToken");
			String game = configJson.getString("game");
			JDA jda = new JDABuilder(AccountType.BOT)
					.setToken(botToken)
					.addEventListener(new InfoCommand())
					.addEventListener(new Music())
                    			.setGame(Game.of(game))
					.setBulkDeleteSplittingEnabled(false)
					.buildAsync();
		} catch(IOException e) {
			System.out.println("Bot config.json not found!");
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
            		e.printStackTrace();
		} catch (RateLimitedException e) {
			e.printStackTrace();
		}




    }
}



