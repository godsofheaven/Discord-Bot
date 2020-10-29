package lavaPlayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayer;

public class GuildMusicManager {
/** N
     * Audio player for the guild.
     */
    public final DefaultAudioPlayer player;
    /**
     * Track scheduler for the player.
     */
    public final TrackScheduler scheduler;


    public GuildMusicManager(DefaultAudioPlayer player) {
        this.player = player;
        scheduler = new TrackScheduler(player);
        player.addListener(scheduler);
    }

    /**
     * @return Wrapper around AudioPlayer to use it as an AudioSendHandler.
     */
    public AudioPlayerSendHandler getSendHandler() {
        return new AudioPlayerSendHandler(player);
    }

}
