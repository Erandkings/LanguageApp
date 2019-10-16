package com.example.android.miwok;


import android.support.v4.app.Fragment;

/**
 * Created by Erandkingson 2/13/2019.
 */
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        // Required empty public constructor
    }


//    MediaPlayer mediaPlayer;
//    AudioManager audioManager;
//
//    /**
//     * Setting a callback function
//     * This is an Asynchronous callback(method)
//     * This will pop up a toast when this method is called or other functions
//     * This is made a global variable so that we don't have to call this method everytime
//     */
//
//    private AudioManager.OnAudioFocusChangeListener audioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
//        @Override
//        public void onAudioFocusChange(int i) {
//            if (i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                mediaPlayer.pause();
//                mediaPlayer.seekTo(0);
//            } else if (i == 1) {
//                mediaPlayer.start();
//            } else if (i == AUDIOFOCUS_LOSS) {
//                releaseMedia();
//            }
//        }
//    };
//
//    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mediaPlayer) {
//            onStop();
//        }
//    };
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.word_list, container, false);
//
////        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
//
//        //ArrayList is used to store variables and maintain its order
//        //It displays the text in the java file instead of hardcoding it in the xml file
//        ArrayList<Word> words = new ArrayList<>();
//
//        words.add(new Word("one", "lutti", R.drawable.images));
//        words.add(new Word("two", "otiiko", R.drawable.images));
//        words.add(new Word("three", "tolookosu", R.drawable.images));
//        words.add(new Word("four", "oyyisa", R.drawable.images));
//        words.add(new Word("five", "massokka", R.drawable.images));
//        words.add(new Word("six", "temmokka", R.drawable.images));
//        words.add(new Word("seven", "kenekaku", R.drawable.images));
//        words.add(new Word("eight", "kawinta", R.drawable.images));
//        words.add(new Word("nine", "wo'e", R.drawable.images));
//        words.add(new Word("ten", "na'aacha", R.drawable.images));
//
//        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_phrases);
//
//        //ListView is a layout that accepts recycling
//        //We cast the xml parent view
//        //This method is declared to refer to the xml file
//        ListView listView = (ListView) view.findViewById(R.id.list);
//        listView.setAdapter(adapter);
////
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_one);
//                Toast.makeText(getActivity(), "Item Clicked", Toast.LENGTH_SHORT).show();
//
//                int result = audioManager.requestAudioFocus(audioFocusListener,
//                        AudioManager.STREAM_MUSIC,
//                        AudioManager.AUDIOFOCUS_GAIN);
//                if (result == AUDIOFOCUS_REQUEST_GRANTED) {
//                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.number_two);
//                    mediaPlayer.start();
//                    mediaPlayer.setOnCompletionListener(completionListener);
//
//                }
//            }
//
//        });
//
//        return  view;
//    }
//
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        releaseMedia();
//    }
//
//    public void releaseMedia() {
//        if (mediaPlayer != null) {
//            mediaPlayer.release();
//        }
//        mediaPlayer = null;
//        audioManager.abandonAudioFocus(audioFocusListener);
//    }

}
