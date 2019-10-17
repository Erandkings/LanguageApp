package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;
import static android.media.AudioManager.AUDIOFOCUS_REQUEST_GRANTED;

/**
 * Created by ERAND on 5/26/2018
 */
public class FamilyFragment extends Fragment {


    public FamilyFragment() {
        // Required empty public constructor
    }

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    /**
     * Setting a callback function
     * This is an Asynchronous callback(method)
     * This will pop up a toast when this method is called or other functions
     * This is made a global variable so that we don't have to call this method everytime
     */

    private AudioManager.OnAudioFocusChangeListener audioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (i == 1) {
                mediaPlayer.start();
            } else if (i == AUDIOFOCUS_LOSS) {
                releaseMedia();
            }
        }
    };

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            onStop();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.word_list, container, false);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //ArrayList is used to store variables and maintain its order
        //It displays the text in the java file instead of hardcoding it in the xml file
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "apa", R.drawable.image));
        words.add(new Word("mother", "ata", R.drawable.image));
        words.add(new Word("son", "angsi", R.drawable.image));
        words.add(new Word("daughter", "tune", R.drawable.image));
        words.add(new Word("older brother", "taachi", R.drawable.image));
        words.add(new Word("younger brother", "chalitti", R.drawable.image));
        words.add(new Word("older sister", "tete", R.drawable.image));
        words.add(new Word("younger sister", "kolliti", R.drawable.image));
        words.add(new Word("grandmother", "ama", R.drawable.image));
        words.add(new Word("grandfather", "paapa", R.drawable.image));

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);

        //ListView is a layout that accepts recycling
        //We cast the xml parent view
        //This method is declared to reference the xml file
        ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_one);
                Toast.makeText(getActivity(), "Item Clicked", Toast.LENGTH_SHORT).show();

                int result = audioManager.requestAudioFocus(audioFocusListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN);
                if (result == AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_two);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);
                }
            }
        });

        return view;
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMedia();
    }

    public void releaseMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = null;
        audioManager.abandonAudioFocus(audioFocusListener);
    }
}
