package tv.circuitrcay.matebot.twitch;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;


public class CommandsTwitch extends ListenerAdapter {
    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        if (event.getMessage().startsWith("mate.comms"))
            event.respond("So far, the only commands are: mate.ping and mate.comms");
    }
}

