package tv.circuitrcay.matebot.commands;



import net.dv8tion.jda.core.JDAInfo;
import net.dv8tion.jda.core.MessageBuilder;


import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Arrays;

import java.util.List;




public class HelpCommand extends Command {




    @Override

    public void onCommand(MessageReceivedEvent e, String[] args)

    {



        MessageBuilder builder = new MessageBuilder();

        builder.append("__MateBot Commands__\n")

                .append("    **Information**:        " + "mate.info" + "\n")

                .append("    **Commands**:                " +  "mate.info" + "\n")

                .append("    **Ping**:          	" + "mate.ping" + "\n")

                .append("    **More coming soon**\n");



        sendMessage(e, builder.build());

    }



    @Override

    public List<String> getAliases()

    {

        return Arrays.asList("mate.comms");

    }



    @Override

    public String getDescription()

    {

        return "Provides commands for MateBot.";

    }



    @Override

    public String getName()

    {

        return "MateBot Commands";

    }



    @Override

    public List<String> getUsageInstructions()

    {

        return Arrays.asList("mate.comms - Prints all the current commands of MateBot");

    }

}