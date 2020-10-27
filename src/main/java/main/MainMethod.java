package main;

import java.util.ArrayList;
import java.util.Collection;
import javax.security.auth.login.LoginException;
import botCommands.BotInfoCommand;
import botCommands.botDisconnectMemberVoice.DisconnectMember;
import botCommands.botMemberJoin.MemberJoinLeave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class MainMethod {

	public static void main(String[] args) throws LoginException {
		Collection<GatewayIntent> intents = new ArrayList<GatewayIntent>();
		
			intents.add(GatewayIntent.GUILD_MEMBERS);
			intents.add(GatewayIntent.GUILD_MESSAGE_TYPING);
			intents.add(GatewayIntent.GUILD_MESSAGES);
			intents.add(GatewayIntent.GUILD_VOICE_STATES);
			intents.add(GatewayIntent.GUILD_EMOJIS);

		JDA jda = JDABuilder.createDefault("YOUR_BOT_TOKEN_HERE", intents).setStatus(OnlineStatus.DO_NOT_DISTURB).build();

		
		
		jda.addEventListener(new DisconnectMember());
		jda.addEventListener(new MemberJoinLeave());
		jda.addEventListener(new BotInfoCommand());
		
	}


}
