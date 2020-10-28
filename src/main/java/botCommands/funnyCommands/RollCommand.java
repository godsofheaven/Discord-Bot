package botCommands.funnyCommands;

import botCommands.BaseCommand;
import botCommands.CommandCategory;
import embedBuilders.EmbedCommands;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class RollCommand extends BaseCommand {
    Random rng;
    Pattern dice = Pattern.compile("(\\d+)d(\\d+)\\+?(\\d+)?");

    @Override
    public String run() {
        rng = new Random();
        return String.format("You rolled %d", rng.nextInt());
    }

    @Override
    public String getName() {
        return "roll a dice";
    }

    @Override
    public String getUsage(Guild guild) {
        return "!roll";
    }

    @Override
    public String getDescription() {
        return "if you ever need a random number";
    }


    @Override
    public String[] getAliases() {
        return new String[]{
                "dice",
                "rng"
        };
    }

    @Override
    public CommandCategory getParentCategory() {
        return null;
    }


    public String multiDice(int dices, int sides, int bonus) {
        String text = String.format("Rolling %s x %s-sided dice: ", dices, sides);
        int total = 0;
        for (int i = 0; i < dices; i++) {
            int roll = rng.nextInt(sides) + 1;
            text += " " + roll;
            total += roll;
        }
        if (bonus != 0) {
            text += " adding " + bonus;
            total += bonus;
        }
        return text + " Total: **" + total + "**";
    }
}
