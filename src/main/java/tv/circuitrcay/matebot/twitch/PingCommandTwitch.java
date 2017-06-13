package tv.circuitrcay.matebot.twitch;



import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;



public class PingCommandTwitch extends ListenerAdapter {
    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        if (event.getMessage().startsWith("mate.ping"))
            event.respond("Pong!");
    }

}