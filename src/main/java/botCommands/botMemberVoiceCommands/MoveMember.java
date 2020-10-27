package botCommands.botMemberVoiceCommands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class MoveMember extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        super.onGuildMessageReceived(event);
        VoiceChannel roomVoiceChannel = event.getGuild().getVoiceChannelById("759022168125734925");
        VoiceChannel loungeVoiceChannel = event.getGuild().getVoiceChannelById("759022168125734924");

        Member memberToBeMoved = event.getMember();
        String[] moveMessage = event.getMessage().getContentRaw().split(" ", 1);
        String moveJoinedMessage = String.join(",", moveMessage);
        if (moveMessage.length == 1 && moveJoinedMessage.equalsIgnoreCase("!move room")) {
            try {
                assert memberToBeMoved != null;
                event.getGuild().moveVoiceMember(memberToBeMoved, roomVoiceChannel).queue();
                event.getChannel().sendMessage("IF YOU ARE NOT MOVED TO A NEW VOICE CHANNEL, REPORT AN ISSUE TO `https://github.com/talentedasian/Discord-Bot or https://github.com/godsofheaven/Discord-Bot`")
                        .queue(m -> m.delete().queueAfter(10, TimeUnit.SECONDS));
            } catch (IllegalStateException e) {
                event.getChannel().sendMessage("`CONNECT` to a voice channel first").queue();
            }

        }
            else if ((moveMessage.length == 1 && moveJoinedMessage.equalsIgnoreCase("!move lounge"))){
            try {
                assert memberToBeMoved != null;
                event.getGuild().moveVoiceMember(memberToBeMoved, loungeVoiceChannel).queue();
                event.getChannel().sendMessage("IF YOU ARE NOT MOVED TO A NEW VOICE CHANNEL, REPORT AN ISSUE TO" +
                        "`https://github.com/talentedasian/Discord-Bot or https://github.com/godsofheaven/Discord-Bot`")
                        .queue(m -> m.delete().queueAfter(10, TimeUnit.SECONDS));
            } catch (IllegalStateException e) {
                event.getChannel().sendMessage("`CONNECT` to a voice channel first").queue();
            }
        }
    }

}

