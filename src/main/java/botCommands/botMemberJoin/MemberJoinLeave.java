package botCommands.botMemberJoin;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoinLeave extends ListenerAdapter {
	EmbedBuilder build = new EmbedBuilder();
	
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		super.onGuildMemberJoin(event);
		TextChannel channel = event.getGuild().getDefaultChannel();
		EmbedBuilder build = new EmbedBuilder();
		build.setColor(Color.DARK_GRAY);
		build.setDescription(">>> Type !help to see some useful commands");
		event.getGuild().getDefaultChannel().sendMessage(build.build()).queue(m -> m.delete().queueAfter
				(1, TimeUnit.HOURS));
		
	
	
	
	
	
	}



}
