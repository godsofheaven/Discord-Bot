package botCommands;

<<<<<<< HEAD
import java.awt.Color;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

=======
>>>>>>> upstream/main
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
					).queue(m->m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!italic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.CYAN,
							"```put '* or _' before and after your text```")
					).queue(m->m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!underline" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__' before and after your text```")
					).queue(m->m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!bolditalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.ORANGE,
							"```put  '***' before and after your text```")
					).queue(m->m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!underlineitalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.RED,
							"```put  '__*' before and after your text```")
					).queue(m->m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!underbold" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__**' before and after your text```")
					).queue(m->m.delete().queueAfter(5, TimeUnit.SECONDS));
					case "!underlinebolditalic" -> channel.sendMessage(embeds.textsEmbedMessage(Color.DARK_GRAY,
							"```put  '__***' before and after your text```")).queue(m->m.delete().queueAfter(5, TimeUnit.SECONDS));
				
						case "!voice"->
					channel.sendMessage(embeds.texts(Color.black, ">  Commands for Voice channel",
							"Type the Following Commands",
							"`!disconnect me - voice command to disconnect" +
							"\n!move (voicechannelname)`",
							false).build()).queue(m->m.delete().queueAfter(5, TimeUnit.SECONDS));
						
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

	
		

	






