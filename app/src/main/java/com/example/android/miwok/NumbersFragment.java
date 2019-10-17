package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ERAND on 5/26/2018
 */
public class NumbersFragment extends Fragment{

    public NumbersFragment(){
        //Required empty public constructor
    }

    AudioManager audioManager;

    MediaPlayer mediaPlayer;

    /**
     * Setting a callback function
     * This is an Asynchronous callback(method)
     * This will pop up a toast when this method is called or other functions
     * This is made a global variable so that we don't have to call this method everytime
     */

    // Since we will request the Listener's input each time we request AudioFocus;
    // We will have to make OnAudioFocusChangeListener a global variable
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int audioFocus) {
            if (audioFocus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || audioFocus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (audioFocus == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (audioFocus == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    // We will need to reuse the OnCompletionListener each time we want to play a song,
    // therefore, we make the OnCompletionListener a global variable and then reuse it.
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mPlayer) {
            Toast.makeText(getActivity(), "Setting up MediaPlayer callbacks", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, parent, false);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        Log.v("NumbersFragment.this", "Class never in use");

        //ArrayList is used to store variables and maintain its order
        //It displays the text in the java file instead of hardcoding it in the xml file
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("one", "lutti", R.drawable.image, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.image, R.raw.number_three));
        words.add(new Word("three", "tolookosu", R.drawable.image, R.raw.number_four));
        words.add(new Word("four", "oyyisa", R.drawable.image, R.raw.number_five));
        words.add(new Word("five", "massokka", R.drawable.image, R.raw.number_two));
        words.add(new Word("six", "temmokka", R.drawable.image, R.raw.number_three));
        words.add(new Word("seven", "kenekaku", R.drawable.image, R.raw.number_four));
        words.add(new Word("eight", "kawinta", R.drawable.image, R.raw.number_five));
        words.add(new Word("nine", "wo'e", R.drawable.image, R.raw.number_one));
        words.add(new Word("ten", "na'aacha", R.drawable.image, R.raw.number_five));

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        //ListView is a layout that accepts recycling
        //We cast the xml parent view
        //This method is declared to refer to the xml file
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        Log.i("listView", "Checking for log");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getActivity(), "Item Clicked", Toast.LENGTH_SHORT).show();
                Word word = words.get(position);

                /**
                 * Calling the AudioManager class from the android framework(API)
                 * This class request for the audio presence whenever an audio related file
                 * is clicked on the device by calling the class AudioManager
                 */

                // The requestAudioFocus method takes in 3 parameters (the callback function, the type of sound, the duration of the sound)
                int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Type of sound we want to play
                        AudioManager.STREAM_MUSIC,
                        // The Duration of the song
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    // Calling the static method .create to create an audio file
                    mediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());

                    // This method starts playing a music
                    mediaPlayer.start();
                    Log.i("mediaPlayer", "this is the mediaPlayer");

                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }

    // This method will cause the audio sound to stop on minimizing
    @Override
    public void onStop() {
        super.onStop();
        Log.i("onStop", "Stop playing sound and release resources");
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = null;

        audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }
}