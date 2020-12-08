package main;

import botCommands.BotInfoCommand;
import botCommands.PingCommand;
import botCommands.botMemberVoiceCommands.DisconnectMember;
import botCommands.botMemberJoin.MemberJoinLeave;
import botCommands.botMemberVoiceCommands.MoveMember;
import com.sedmelluq.discord.lavaplayer.jdaudp.NativeAudioSendFactory;
import lavaPlayer.YoutubeSearch;
import botCommands.botProfanityFilter.ProfanityFilter;
import embedBuilders.EmbedCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;

public class MainMethod {


    public static void main(String[] args)throws LoginException {
		Collection<GatewayIntent> intents = new ArrayList<>();

			intents.add(GatewayIntent.GUILD_MEMBERS);
			intents.add(GatewayIntent.GUILD_MESSAGE_TYPING);
			intents.add(GatewayIntent.GUILD_MESSAGES);
			intents.add(GatewayIntent.GUILD_VOICE_STATES);
			intents.add(GatewayIntent.GUILD_EMOJIS);

		JDA jda = JDABuilder.createDefault("", intents).setAudioSendFactory(new NativeAudioSendFactory())
				.setActivity(Activity.listening("Spotify"))
				.setStatus(OnlineStatus.ONLINE).build();

		jda.addEventListener(new PingCommand());
		jda.addEventListener(new MoveMember());
		jda.addEventListener(new DisconnectMember());
		jda.addEventListener(new MemberJoinLeave());
		jda.addEventListener(new BotInfoCommand());
		jda.addEventListener(new YoutubeSearch());
		jda.addEventListener(new ProfanityFilter());
		jda.addEventListener(new EmbedCommands());
	}
}
