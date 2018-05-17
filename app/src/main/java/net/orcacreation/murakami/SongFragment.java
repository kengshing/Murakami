package net.orcacreation.murakami;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongFragment extends Fragment {

    private MediaPlayer mMedisPlayer;
    private AudioManager mAudioManager;
    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AUDIOFOCUS_LOSS_TRANSIENT:
                case AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mMedisPlayer.pause();
                    mMedisPlayer.seekTo(0);
                    break;
                case AUDIOFOCUS_GAIN:
                    mMedisPlayer.start();
                    break;
                case AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    break;
            }
        }
    };

    private final MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMedisPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMedisPlayer.release();
// Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMedisPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    public SongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container, false);

        final ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info("When You Are Smiling", "Billie Holiday", R.drawable.img_billie_holiday, R.raw.miss));
        infos.add(new Info("I Fall In Love Too Easily", "Chet Baker", R.drawable.img_chet_baker, R.raw.you_said));
        infos.add(new Info("The Girl From Ipanema", "Stan Getz", R.drawable.img_stan_getz, R.raw.thousand_miles));
        infos.add(new Info("Over The Rainbow", "Sarah Vaughan", R.drawable.img_sarah_vaughan, R.raw.in_the_name_of_love));
        infos.add(new Info("A Night In Tunisia", "Dizzy Gillespie", R.drawable.img_dizzy_gillespie, R.raw.ex_is_like_dream));
        infos.add(new Info("Black And Blue", "Louis Armstrong", R.drawable.img_louis_armstrong, R.raw.walk_with_you));

        InfoAdaptor itemAdaptor = new InfoAdaptor(getActivity(), R.layout.info_list_item, infos, R.color.category_song);
        ListView listView = rootView.findViewById(R.id.info_list);
        listView.setAdapter(itemAdaptor);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Info info = infos.get(position);
                releaseMediaPlayer();
                //AudioFucus request
                int res = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMedisPlayer = MediaPlayer.create(getActivity(), info.getmResourceId());
                    mMedisPlayer.setVolume(1, 1);
                    mMedisPlayer.start();
                    mMedisPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
