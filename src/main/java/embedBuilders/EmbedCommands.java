package embedBuilders;

import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

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
		
		
		
		
 
}
