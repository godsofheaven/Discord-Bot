package botCommands.botMemberVoiceCommands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class DisconnectMember extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        Member memberToBeDisconnected = event.getMember();
        String[] disconnectMessage = event.getMessage().getContentRaw().split(" ", 1);
        String disconnectJoinedMessage = String.join(",", disconnectMessage);
            if (disconnectMessage.length == 1 && disconnectJoinedMessage.equalsIgnoreCase("!disconnect me")) {
                event.getGuild().kickVoiceMember(memberToBeDisconnected).queue();
                event.getChannel().sendMessage("YOU HAVE BEEN DISCONNECTED IN THE VOICE CHANNEL").queue(
                        m -> m.delete().queueAfter(10, TimeUnit.SECONDS));
            }

    }
}
