package botCommands;

import java.util.List;

public abstract class CommandCategory {
    /**
     * Get a command from this category
     * @param cmd - Command's name
     * @return Command or null
     *
     */
    public abstract BaseCommand getCommand(String cmd);

    /**
     * Get the list of commands in this category
     *
     */
    public abstract List<BaseCommand> getCommands();

    /**
     * Get this category's name
     *
     */
    public abstract String getName();
}
