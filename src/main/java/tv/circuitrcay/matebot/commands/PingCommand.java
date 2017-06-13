package tv.circuitrcay.matebot.commands;


import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
       String msg = event.getMessage().getContent();

               if (msg.equalsIgnoreCase("mate.ping")) {
                    event.getChannel().sendMessage("Pong!");
               }
    }
}
