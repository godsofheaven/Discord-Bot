package lavaPlayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackScheduler extends AudioEventAdapter {
    private final DefaultAudioPlayer player;
    private final BlockingQueue<AudioTrack> queue;

    /**
     * @param player The audio player this scheduler uses
     */
    public TrackScheduler(DefaultAudioPlayer player) {
        this.player = player;
        this.queue = new LinkedBlockingQueue<>();

    }




    /**
     * Add the next track to queue or play right away if nothing is in the queue.
     *
     * @param track The track to play or add to queue.
     */
    public void queue(AudioTrack track) {
        // Calling startTrack with the noInterrupt set to true will start the track only if nothing is currently playing. If
        // something is playing, it returns false and does nothing. In that case the player was already playing so this
        // track goes to the queue instead.
        if (player.getPlayingTrack() == null) {
            queue.offer(track);




        }
            else if (!(player.getPlayingTrack() == null )) {
                queue.offer(track);
        }


    }




    /**
     * Start the next track, stopping the current one if it is playing.
     */
    public void nextTrack() {
        // Start the next track, regardless of if something is already playing or not. In case queue was empty, we are
        // giving null to startTrack, which is a valid argument and will simply stop the player.
        player.startTrack(queue.poll(), false);
    }



    public void pauseTrack(){
        //pause the played track
        player.setPaused(true);
    }

    public void resumeTrack() {
        //resume the paused track
        player.setPaused(false);
    }

    @Override
    public void onTrackStart(AudioPlayer player, AudioTrack track) {
        super.onTrackStart(player, track);
        String trackInfo = track.getInfo().toString();
        Logger log = LoggerFactory.getLogger(TrackScheduler.class);
    }

    public void stopTrack() {
        //stop track
        player.stopTrack();
        player.playTrack(queue.poll());
    }



    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        // Only start the next track if the end reason is suitable for it (FINISHED or LOAD_FAILED)
        if (endReason.mayStartNext) {
            nextTrack();
        }

    }



}
