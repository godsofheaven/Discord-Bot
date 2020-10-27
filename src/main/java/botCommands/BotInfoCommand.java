package botCommands;

import java.awt.Color;import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotInfoCommand extends ListenerAdapter {
			EmbedCommands embeds = new EmbedCommands();
			 

	
			@Override
			public void onMessageReceived(MessageReceivedEvent event) throws NullPointerException {
			super.onMessageReceived(event);
			MessageChannel channel = event.getChannel();
			String message = event.getMessage().getContentRaw();
			
			
			
			if(message.equalsIgnoreCase("!markdown")){
				channel.sendMessage(botCommands.EmbedCommands.texts(Color.BLACK, "> Markdown Commands",
						"Type the Following Commands to know more", "`!bold` `\n!italic` `\n!underline` `\n!bolditalic` "
								+ "`\n!underlineitalic` `\n!underlinebold` `\n!unerlinebolditalic` `\n!strikethrough`", 
						true).build()).queue();
			
			
			}
				else if (message.equalsIgnoreCase("!bold")) {
					channel.sendMessage(botCommands.EmbedCommands.textsEmbedMessage(Color.PINK, 
							"``` put '**' before and after your text```")
							).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				}
				else if (message.equalsIgnoreCase("!italic")) {
					channel.sendMessage(botCommands.EmbedCommands.textsEmbedMessage(Color.CYAN, 
							"```put '* or _' before and after your text```")
							).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				}
			
				else if (message.equalsIgnoreCase("!underline")) {
					channel.sendMessage(botCommands.EmbedCommands.textsEmbedMessage(Color.DARK_GRAY, 
							"```put  '__' before and after your text```")
							).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				}
				else if (message.equalsIgnoreCase("!bolditalic")) {
					channel.sendMessage(botCommands.EmbedCommands.textsEmbedMessage(Color.ORANGE, 
							"```put  '***' before and after your text```")
							).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				}
				else if (message.equalsIgnoreCase("!underlineitalic")) {
					channel.sendMessage(botCommands.EmbedCommands.textsEmbedMessage(Color.RED, 
							"```put  '__*' before and after your text```")
							).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				}
				else if (message.equalsIgnoreCase("!underbold")) {
					channel.sendMessage(botCommands.EmbedCommands.textsEmbedMessage(Color.DARK_GRAY,  
							"```put  '__**' before and after your text```")
							).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				}
				else if (message.equalsIgnoreCase("!underlinebolditalic")) {
					channel.sendMessage(botCommands.EmbedCommands.textsEmbedMessage(Color.DARK_GRAY, 
							"```put  '__***' before and after your text```")
							).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
				}
				else if (message.equalsIgnoreCase("!help")) {
					channel.sendMessage(botCommands.EmbedCommands.texts(Color.WHITE, "> Useful Commands",
							"Type the Following Commands",
							"`!disconnect me` - disconnect yourself in the voice channel using the bot`",
							false).build()).queue();
					
				}
				
			
}	
}
	
		

	






