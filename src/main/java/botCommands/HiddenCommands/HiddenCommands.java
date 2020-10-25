package botCommands.HiddenCommands;

import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HiddenCommands extends ListenerAdapter {
		
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		super.onGuildMessageReceived(event);
		
		String message = event.getMessage().getContentRaw();
		TextChannel channel = event.getChannel();
		Message messageToBeDeleted = event.getMessage();
		
		if (message.equalsIgnoreCase(">>>past ni gelo kay joanna")) {
			messageToBeDeleted.delete().queueAfter(1, TimeUnit.MILLISECONDS);
			EmbedBuilder build = new EmbedBuilder();
			build.setTitle("KAUHAWAN NI ANGELO JERBAKS");
			build.setDescription("```ini\n[ONCE UPON A TIME NUNG NAGKAGUSTO SI GELO KAY JOANNA LAGI  NA NYA ITONG STINASTALK KASAMA ANG KANYANG MABUTING "
					+ "KABIGAN NA SI JAMES, LAGI NILA ITONG INAABANGAN SA KANTO BAGO ITO PUMASOK DAHIL SIGURO EH STALKER NGA SI GELO. HANGGAT SA"
					+ "SI GELO AY SUMUKO DAHIL DUMATING ANG ISA PANG J SA KANYANG BUHAY]```");
			build.setImage("https://scontent.fmnl6-1.fna.fbcdn.net/v/t31.0-8/25"
					+ "54252"
					+ "5_1686751928052438_833805263762490100_o.jpg?_nc_cat=103&ccb"
					+ "=2&_nc_sid=174925&_nc_eui2=AeG4925Z7fT_h3XoZcCVbgesZAquv9"
					+ "0QttlkCq6_3RC22ShVusY-TkjYlXWodUY_a8irNJuy56FcuJSqW1RNpACG"
					+ "&_nc_ohc=x2AjXAEw01gAX9ZxIqR&_nc_ht=scontent.fmnl6-1.fna&oh=a"
					+ "9d0e365f6216d056dab45a87f198c71&oe=5FB85C14");
			channel.sendMessage(build.build()).queue((m) -> m.delete().queueAfter(750, TimeUnit.MILLISECONDS));		
							
		}
		
		if (message.equalsIgnoreCase(">>>past ni gelo kay jeanne")) {
			
			messageToBeDeleted.delete().queue();
			EmbedBuilder build = new EmbedBuilder();
			build.setTitle("KWENTO NG KAUHAWAN NI ANGELO JERBAKS");
			build.setDescription("```ini\n[ONCE UPON A TIME MERON AKONG FEELING ATE TSAKA FEELING KUYA NA NAGKAGUSTO SA ISA'T ISA AT NAGTAGUAN NG FEELINGS,"
					+ "HINDI NILA ALAM NA NAGKAKAGUSTO NA PALA SILA SA ISA'T ISA AT AYU NA NGA. NANG MATAPOS NA ANG SCHOOL YEAR NAMEN AY NAGKA AMINAN "
					+ "ANG DALAWA NA MAY GUSTO SILA SA ISA'T ISA HANGGANG SA NAGING SILA. NGUNIT SA KASAMAANG PALAD AY PINAGPALIT SI JEANNE NI GELO "
					+ "NANG DAHIL SA PAG-AARAL NITO. KUMAKALAT NGAUN ANG MGA SABI SABI NA MAYROON PARIN SILANG GUSTO SA ISA'T ISA]```");
			build.setImage("https://scontent.fmnl6-2.fna.fbcdn.net/v/t1.15752-0/p280x2"
					+ "80/122045832_691940211449631_4016648867961609886_n.png?_nc_cat=10"
					+ "6&ccb=2&_nc_sid=ae9488&_nc_eui2=AeG3pVUdS4ze0Isopkga387xuF2nJ-ff"
					+ "jwe4Xacn59-PB6sTZd1WVh_EQpQGY9WBMvIh5L_ajJPPfNdfXfvu-tXV&_nc_oh"
					+ "c=Fd1UzSTN9KwAX8QUwY7&_nc_ht=scontent.fmnl6-2.fna&oh=c4a86e791f"
					+ "d5fad06654df658c23e4c8&oe=5FB5920A");
			channel.sendMessage(build.build()).queue(m -> m.delete().queueAfter(1200, TimeUnit.MILLISECONDS));
			
			
		}
	
	
	}
		
			
			
}
