package botCommands;

import embedBuilders.EmbedCommands;
import net.dv8tion.jda.api.entities.MessageChannel;
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
							"Type the Following Commands to know more", "`!bold` `\n!italic` `\n!underline` `\n!bolditalic` "
									+ "`\n!underlineitalic` `\n!underlinebold` `\n!unerlinebolditalic` `\n!strikethrough \n!voice`",
							true).build()).queue();
					case "!bold" -> channel.sendMessage(embeds.textsEmbedMessage(Color.PINK,
							"``` put '**' before and after your text```")
					).queue();
					case "!italic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.CYAN,
							"```put '* or _' before and after your text```")
					).queue();
					case "!underline" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__' before and after your text```")
					).queue();
					case "!bolditalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.ORANGE,
							"```put  '***' before and after your text```")
					).queue();
					case "!underlineitalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.RED,
							"```put  '__*' before and after your text```")
					).queue();
					case "!underbold" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__**' before and after your text```")
					).queue();
					case "!underlinebolditalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__***' before and after your text```"));
				
						case "!voice"->
					channel.sendMessage(embeds.texts(Color.black, ">  Commands for Voice channel",
							"Type the Following Commands",
							"`!disconnect me - voice command to disconnect" +
							"\n!move room - move another room`",
							false).build()).queue();
						
							case "!help"->
							channel.sendMessage(embeds.texts(Color.black, "> Helpful Command ",
									"Type the Following Commands"
									,"`help command`",
									false).build()).queue();

					// ).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
					// case "!help" -> channel.sendMessage(embeds.texts(Color.WHITE, "> Useful Commands", "Type the Following Commands",
					// 		"dds", false).build()).queue();

			}

			
}
}	

	
		

	






