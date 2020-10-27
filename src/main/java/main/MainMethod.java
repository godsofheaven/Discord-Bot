package main;

import botCommands.BotInfoCommand;
import botCommands.botDisconnectMemberVoice.DisconnectMember;
import botCommands.botMemberJoin.MemberJoinLeave;
import botCommands.botMemberVoiceCommands.MoveMember;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Collection;

public class MainMethod {
	private static MainMethod instance;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static MainMethod getInstance() {
		return instance;
	}

	public static void setInstance(MainMethod instance) {
		MainMethod.instance = instance;
	}

	public static void main(String[] args) throws LoginException {
		Collection<GatewayIntent> intents = new ArrayList<GatewayIntent>();

			intents.add(GatewayIntent.GUILD_MEMBERS);
			intents.add(GatewayIntent.GUILD_MESSAGE_TYPING);
			intents.add(GatewayIntent.GUILD_MESSAGES);
			intents.add(GatewayIntent.GUILD_VOICE_STATES);
			intents.add(GatewayIntent.GUILD_EMOJIS);

		JDA jda = JDABuilder.createDefault("NzcwMzM1MjE0MjQ0MzMxNTMw.X5cEkw.y3mOWnhKNFd_raJnG4QFHy48XV4", intents).setStatus(OnlineStatus.DO_NOT_DISTURB).build();

		jda.addEventListener(new MoveMember());
		jda.addEventListener(new DisconnectMember());
		jda.addEventListener(new MemberJoinLeave());
		jda.addEventListener(new BotInfoCommand());
	}


}
