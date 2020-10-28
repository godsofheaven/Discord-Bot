package botCommands;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class PingCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        if (event.getMessage().getContentRaw().toLowerCase().equals("!ping")) {
            channel.sendMessage("Pong!").queue();
        }
    }
}
