package lavaPlayer;

import java.util.HashMap;
import java.util.Map;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import botCommands.EmbedCommands;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class MusicPlayer extends ListenerAdapter{

	
	  	private  AudioPlayerManager playerManager;
	  	private Map<Long, GuildMusicManager> musicManagers;
	  	EmbedMessages embeds = new EmbedMessages();

	  public MusicPlayer() {
	    this.musicManagers = new HashMap<>();
	    this.playerManager = new DefaultAudioPlayerManager();
	    AudioSourceManagers.registerRemoteSources(playerManager);
	    AudioSourceManagers.registerLocalSource(playerManager);
	  }
	  
	  private synchronized GuildMusicManager getGuildAudioPlayer(Guild guild) {
	    long guildId = Long.parseLong(guild.getId());
	    GuildMusicManager musicManager = musicManagers.get(guildId);

	    if (musicManager == null) {
	      musicManager = new GuildMusicManager(playerManager);
	      musicManagers.put(guildId, musicManager);
	    }

	    guild.getAudioManager().setSendingHandler(musicManager.getSendHandler());

	    return musicManager;
	  }
	   	
	  @Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		super.onGuildMessageReceived(event);
		
		String[] command = event.getMessage().getContentRaw().split(" ", 2);
		if("~play".equals(command)&& command.length == 2) {
			loadAndPlay(event.getChannel(), command[1]);
	  
	  }





}

	private void loadAndPlay(final TextChannel channel, final String songUrl) {
			GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
			
			playerManager.loadItemOrdered(musicManager, songUrl, new AudioLoadResultHandler() {
				
				@Override
				public void trackLoaded(AudioTrack track) {
					// TODO Auto-generated method stub
					channel.sendMessage(embeds.buildMusicMessage("Music Command", "Track is Now Being added", false));
					play(channel.getGuild(), musicManager, track);
				}
				

				@Override
				public void playlistLoaded(AudioPlaylist playlist) {
					// TODO Auto-generated method stub
					AudioTrack firstTrack = playlist.getSelectedTrack();
					
					if(firstTrack == null) {
						firstTrack = playlist.getTracks().get(0);
					}
				
				}
				
				@Override
				public void noMatches() {
					// TODO Auto-generated method stub
					channel.sendMessage(embeds.buildMusicMessage("MUSIC COMMANDS", "COULD NOT FIND + " + songUrl, false));
				}
				
				@Override
				public void loadFailed(FriendlyException exception) {
					channel.sendMessage(embeds.buildMusicMessage("MUSIC COMMANDS", "COULD NOT PLAY" + exception.getMessage()
							,false)).queue();
					
				}
			});
			
				
		
				
	}
				private void play(Guild guild, GuildMusicManager musicManager, AudioTrack track) {
					// TODO Auto-generated method stub
					connectToVoiceFirstChannel(guild.getAudioManager());
					musicManager.scheduler.queue(track);
				}

				private static void connectToVoiceFirstChannel(AudioManager audioManager ) {
					// TODO Auto-generated method stub
					if(!audioManager.isConnected()) {
						 for (VoiceChannel voiceChannel : audioManager.getGuild().getVoiceChannels()) {
						        audioManager.openAudioConnection(voiceChannel);
						        break;
					
					
			}

		}
	}
}

		
	
	




