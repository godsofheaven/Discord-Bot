package botCommands.botMemberJoin;



import java.awt.Color;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MemberJoinLeave extends ListenerAdapter {
	EmbedBuilder build = new EmbedBuilder();
	
	@Override
	public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
		super.onGuildMemberJoin(event);
		TextChannel channel = event.getGuild().getDefaultChannel();
		EmbedBuilder build = new EmbedBuilder();
		build.setColor(Color.DARK_GRAY);
		build.setDescription(">>> Type !help to see some useful commands");
		Objects.requireNonNull(event.getGuild().getDefaultChannel()).sendMessage(build.build()).queue(m -> m.delete().queueAfter
				(1, TimeUnit.HOURS));
	}

	@Override
	public void onGuildMemberRemove(GuildMemberRemoveEvent event){
		super.onGuildMemberRemove(event);
		TextChannel channel = event.getGuild().getDefaultChannel();
		String user = Objects.requireNonNull(event.getMember()).getUser().getAsMention();
		EmbedBuilder builder = new EmbedBuilder();
		build.setColor(Color.DARK_GRAY);
		build.setDescription("The user" + user + "has left the server");
		Objects.requireNonNull(event.getGuild().getDefaultChannel()).sendMessage(build.build()).queue(message -> message.delete().queueAfter(1,TimeUnit.HOURS));
	}
}
