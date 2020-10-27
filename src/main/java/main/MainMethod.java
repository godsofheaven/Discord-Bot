package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.security.auth.login.LoginException;
import botCommands.BotInfoCommand;
import botCommands.botMemberVoiceCommands.DisconnectMember;
import botCommands.botMemberJoin.MemberJoinLeave;
import botCommands.botMemberVoiceCommands.MoveMember;
import lavaPlayer.LavaPlayerMain;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.SnowflakeCacheView;

public class MainMethod {

	public static void main(String[] args) throws LoginException {
		Collection<GatewayIntent> intents = new ArrayList<GatewayIntent>();

			intents.add(GatewayIntent.GUILD_MEMBERS);
			intents.add(GatewayIntent.GUILD_MESSAGE_TYPING);
			intents.add(GatewayIntent.GUILD_MESSAGES);
			intents.add(GatewayIntent.GUILD_VOICE_STATES);
			intents.add(GatewayIntent.GUILD_EMOJIS);

		JDA jda = JDABuilder.createDefault("NzU3NTE3MzcwNjE2MTg0ODgz.X2hjBw.04Xe4TCC228j6g1M4W00uSLhVMI", intents).setStatus(OnlineStatus.DO_NOT_DISTURB).build();


		jda.addEventListener(new MoveMember());
		jda.addEventListener(new DisconnectMember());
		jda.addEventListener(new MemberJoinLeave());
		jda.addEventListener(new BotInfoCommand());
		jda.addEventListener(new LavaPlayerMain());
	}


}
