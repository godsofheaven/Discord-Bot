package botCommands.funnyCommands;

import botCommands.BaseCommand;
import botCommands.CommandCategory;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchRandom;
import at.mukprojects.giphy4j.exception.GiphyException;

public class GifCommand extends BaseCommand {
    static String API_KEY = "dc6zaTOxFJmzCdc6zaTOxFJmzC";

    Giphy giphy = new Giphy(API_KEY);

    public String GifCommand(String message) throws GiphyException {
        SearchRandom giphyRandom = giphy.searchRandom(message);
        return giphyRandom.getData().getImageOriginalUrl();
    }

    @Override
    public void run(GuildMessageReceivedEvent e, List<String> args) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getUsage(Guild guild) {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public CommandCategory getParentCategory() {
        return null;
    }
}

