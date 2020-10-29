package botCommands.funnyCommands;

import botCommands.BaseCommand;
import botCommands.CommandCategory;
import net.dv8tion.jda.api.entities.Guild;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand extends BaseCommand {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
    LocalDateTime ldt = LocalDateTime.now();

    @Override
    public String run() {
        return dtf.format(ldt);
    }

    @Override
    public String getName() {
        return "Time and date";
    }

    @Override
    public String getUsage(Guild guild) {
        return "!time";
    }

    @Override
    public String getDescription() {
        return "get the time and date";
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
