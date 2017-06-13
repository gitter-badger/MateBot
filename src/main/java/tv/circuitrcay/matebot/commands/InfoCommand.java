package tv.circuitrcay.matebot.commands;



import net.dv8tion.jda.core.JDAInfo;
import net.dv8tion.jda.core.MessageBuilder;


import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Arrays;

import java.util.List;




public class InfoCommand extends Command {




    @Override

    public void onCommand(MessageReceivedEvent e, String[] args)

    {



        MessageBuilder builder = new MessageBuilder();

        builder.append("__MateBot Information__\n")

                .append("    **Version**:        " + "MateBot 1.0.0" + "\n")

                .append("    **ID**:                " + e.getJDA().getSelfUser().getId() + "\n")

                .append("__Creator__\n")

                .append("    **Name**:          	CircuitRCAY" + "\n")

                .append("    **ID**:                255114091360681986\n")

                .append("    **Github**:        	<http://codefromcirc.github.com>\n")

                .append("__Development__\n")

                .append("    **Language**:   		Java 8\n")

                .append("    **Library**:        JDA - v" + JDAInfo.VERSION + "\n")

                .append("    **Source**:        	<https://github.com/CodeFromCirc/MateBot>\n");

        sendMessage(e, builder.build());

    }



    @Override

    public List<String> getAliases()

    {

        return Arrays.asList("mate.info");

    }



    @Override

    public String getDescription()

    {

        return "Provides information about MateBot.";

    }



    @Override

    public String getName()

    {

        return "MateBot Information";

    }



    @Override

    public List<String> getUsageInstructions()

    {

        return Arrays.asList("mate.info - Prints all information pertaining to the current instance of MateBot.");

    }

}