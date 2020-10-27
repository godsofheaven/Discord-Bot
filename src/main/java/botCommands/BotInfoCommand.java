package botCommands;

import java.awt.Color;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import at.mukprojects.giphy4j.exception.GiphyException;
import botCommands.funnyCommands.RollCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotInfoCommand extends ListenerAdapter {
			static EmbedCommands embeds = new EmbedCommands();



			@Override
			public void onMessageReceived(MessageReceivedEvent event) throws NullPointerException {
			super.onMessageReceived(event);
			MessageChannel channel = event.getChannel();
			String message = event.getMessage().getContentRaw();


				switch (message.toLowerCase()) {
					case "!markdown" -> channel.sendMessage(EmbedCommands.texts(Color.BLACK, "> Markdown Commands",
							"Type the Following Commands to know more", "`!bold` `\n!italic` `\n!underline` `\n!bolditalic` "
									+ "`\n!underlineitalic` `\n!underlinebold` `\n!unerlinebolditalic` `\n!strikethrough" +
									"\n!gif`",
							true).build()).queue();
					case "!bold" -> channel.sendMessage(EmbedCommands.textsEmbedMessage(Color.PINK,
							"``` put '**' before and after your text```")
					).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!italic" -> channel.sendMessage(EmbedCommands.textsEmbedMessage(Color.CYAN,
							"```put '* or _' before and after your text```")
					).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!underline" -> channel.sendMessage(EmbedCommands.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__' before and after your text```")
					).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!bolditalic" -> channel.sendMessage(EmbedCommands.textsEmbedMessage(Color.ORANGE,
							"```put  '***' before and after your text```")
					).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!underlineitalic" -> channel.sendMessage(EmbedCommands.textsEmbedMessage(Color.RED,
							"```put  '__*' before and after your text```")
					).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!underbold" -> channel.sendMessage(EmbedCommands.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__**' before and after your text```")
					).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!underlinebolditalic" -> channel.sendMessage(EmbedCommands.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__***' before and after your text```")
					).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!gif" -> {
						try {
							channel.sendMessage(embeds.gifTextMessage().GifCommand(message))
							.queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
						} catch (GiphyException e) {
							channel.sendMessage("An error occured and I couldn't return your drug of choice.");
						}
					}
					case "!roll" -> {

					}
				}
/*				else if (message.equalsIgnoreCase("!help")) {
					channel.sendMessage(embedBuilders.embeds.texts(Color.WHITE, "> Useful Commands",
							"Type the Following Commands",
							"`!disconnect me` - disconnect yourself in the voice channel using the bot`",
							false).build()).queue();


					).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!help" -> channel.sendMessage(embeds.texts(Color.WHITE, "> Useful Commands", "Type the Following Commands",
							"dds", false).build()).queue();

*/				}


}

	
		

	






