package lavaPlayer;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class EmbedMessages {

		EmbedBuilder build = new EmbedBuilder();
		
		public MessageEmbed buildMusicMessage(String name, String value, boolean inline) {
			build.clearFields();
			build.addField(name, value, inline);
			return new EmbedBuilder(build).build();
			
		}
	

}
