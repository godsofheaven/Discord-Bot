package botCommands.funnyCommands;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchRandom;
import at.mukprojects.giphy4j.exception.GiphyException;
import botCommands.BaseCommand;
import botCommands.CommandCategory;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class GifCommand extends BaseCommand {
    static String API_KEY = "OJsVeRIId59XXmi2Sp7Vd1k7y0Cat3CV";
    private CommandCategory category;

    Giphy giphy = new Giphy(API_KEY);

    public String GifCommand(String message) throws GiphyException {
        SearchRandom giphyRandom = giphy.searchRandom(message);
        return giphyRandom.getData().getImageOriginalUrl();
    }

    @Override
    public String run() {

        return null;
    }

    @Override
    public String getName() {
        return "Gif";
    }

    @Override
    public String getUsage(Guild guild) {
        return getName().toLowerCase();
    }

    @Override
    public String getDescription() {
        return "Returns a random gif";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public CommandCategory getParentCategory() {
        return category;
    }

//    @Override
//    public CommandCategory getParentCategory() {
//        return category;
//    }
}

