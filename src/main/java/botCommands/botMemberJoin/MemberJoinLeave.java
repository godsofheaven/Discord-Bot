package botCommands.botMemberJoin;

<<<<<<< HEAD
=======
import java.awt.Color;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

>>>>>>> 0abf7303b3b0a54215c91c1744bb3630ded30d71
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.concurrent.TimeUnit;

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



}
