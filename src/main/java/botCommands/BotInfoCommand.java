package botCommands;

import at.mukprojects.giphy4j.exception.GiphyException;
import embedBuilders.EmbedCommands;
import net.aksingh.owmjapis.api.APIException;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BotInfoCommand extends ListenerAdapter {
	static EmbedCommands embeds = new EmbedCommands();



	@Override
	public void onMessageReceived(MessageReceivedEvent event) throws NullPointerException {
			super.onMessageReceived(event);
			MessageChannel channel = event.getChannel();
			String message = event.getMessage().getContentRaw();


			switch (message.toLowerCase()) {
				case "!markdown" -> channel.sendMessage(embeds.texts(Color.BLACK, "> Markdown Commands",
						"Type the following commands to find out more", "`!bold` `\n!italic` `\n!underline` `\n!bolditalic` "
								+ "`\n!underlineitalic` `\n!underlinebold` `\n!underlinebolditalic` `\n!strikethrough`",
						true).build()).queue();

				case "!voice"-> {
					channel.sendMessage(embeds.texts(Color.BLACK, "Commands",
							"Type the following commands",
							"`!disconnect me - voice command to disconnect" +
									"\n!move (voicechannelname)`",
							false).build()).queue();
				}

				case "!miscellaneous"-> {
					channel.sendMessage(embeds.texts(Color.BLACK, "Commands",
							"Type the following commands",
							"`!roll\n` `!8ball\n` `!time\n` `!gif\n`",
							false).build()).queue();
				}

				case "!help"->{
					channel.sendMessage(embeds.texts(Color.BLACK, "Commands",
							"Type the following commands",
							"`!markdown` `\n!miscellaneous` `\n!voice`",
							false).build()).queue();
				}

				case "!bold" -> channel.sendMessage(embeds.textsEmbedMessage(Color.PINK,
						"``` put '**' before and after your text```")
				).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				case "!italic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.CYAN,
						"```put '* or _' before and after your text```")
				).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				case "!underline" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
						"```put  '__' before and after your text```")
				).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				case "!bolditalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.ORANGE,
						"```put  '***' before and after your text```")
				).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				case "!underlineitalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.RED,
						"```put  '__*' before and after your text```")
				).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				case "!underbold" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
						"```put  '__**' before and after your text```")
				).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				case "!underlinebolditalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
						"```put  '__***' before and after your text```")
				).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				case "!roll" ->{
					channel.sendMessage(embeds.textString(embeds.rollDice())).queue();
				}
				case "!8ball" ->{
					channel.sendMessage(embeds.textString(embeds.eightBall())).queue();
				}
				case "!time" ->{
					channel.sendMessage(embeds.textString(embeds.time())).queue();
				}
			}
	}
}	

	
		

	






