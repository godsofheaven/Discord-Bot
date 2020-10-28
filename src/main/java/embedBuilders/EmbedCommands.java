package embedBuilders;

import java.awt.Color;
import java.util.List;

import botCommands.funnyCommands.GifCommand;
import main.MainMethod;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

public class EmbedCommands {

		static EmbedBuilder embed = new EmbedBuilder();
	
		public EmbedBuilder texts(Color color, String description, String name, String value, boolean inline) {
		embed.clearFields();
		return new EmbedBuilder(embed).setColor(color).setDescription(description).addField(name, value, inline);
		}
		
		public MessageEmbed textsEmbedMessage(Color color, String description ) {
			embed.clearFields();
			return new EmbedBuilder(embed).setColor(color).setTitle("> MARKDOWN COMMAND").setDescription(description).build();
		
		}

		public GifCommand gifTextMessage(){
				embed.clearFields();
				return new GifCommand();
			}

		public static EmbedBuilder noFieldMessageEmbed(String name, List<String> msgs, MessageChannel channel) {
			return noFieldMessageEmbed(name, msgs, new Color(52, 128, 235), channel);
		}

		public static EmbedBuilder noFieldMessageEmbed(String name, List<String> msgs, Color color, MessageChannel channel) {
			EmbedBuilder builder = new EmbedBuilder();
			builder.setColor(color);
			if(msgs.size() != 0) {
				String finalMsg = msgs.get(0);
				for (int i = 1; i < msgs.size(); i++) {
					finalMsg = finalMsg + "\n" + msgs.get(i);
				}
				builder.addField(name, finalMsg, false);
			}
			if (channel instanceof TextChannel) {
				builder.setFooter(((TextChannel) channel).getGuild().getName() + " - " + MainMethod.getInstance().getName(),
						((TextChannel) channel).getGuild().getIconUrl());
			}
			return builder;
		}
}
