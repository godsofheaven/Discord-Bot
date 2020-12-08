package botCommands.Miscellaneous;

import botCommands.BaseCommand;
import botCommands.CommandCategory;
import net.dv8tion.jda.api.entities.Guild;

public class EightballCommand extends BaseCommand {
    private final String[] array = {
            "As I see it, yes",
            "Better not tell you now",
            "Cannot predict now",
            "Don't count on it",
            "If you say so",
            "In your dreams",
            "It is certain",
            "Most likely",
            "My CPU is saying no",
            "My CPU is saying yes",
            "Out of psychic coverage range",
            "Signs point to yes",
            "Sure, sure",
            "Very doubtful",
            "When life gives you lemon, you squeeze it in the eye of the storm",
            "Without a doubt",
            "Wow, Much no, very yes, so maybe",
            "Yes, definitely",
            "Yes, unless you run out of memes",
            "You are doomed",
            "You can't handle the truth"};

    @Override
    public String run() {
        return "The eightball shares its wisdom : " + array[(int) (Math.random() * array.length)];
    }

    @Override
    public String getName() {
        return "Eightball";
    }

    @Override
    public String getUsage(Guild guild) {
        return "!8ball";
    }

    @Override
    public String getDescription() {
        return "returns a mighty answer";
    }

    @Override
    public String[] getAliases() {
        return new String[]{
                "eightball",
                "8ball"
        };
    }

    @Override
    public CommandCategory getParentCategory() {
        return null;
    }
}
