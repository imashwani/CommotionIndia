package com.example.ashwani.commotionindia.HomeFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashwani.commotionindia.R;
import com.example.ashwani.commotionindia.YoutubeConfig;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class HomeJoinUsFragment extends Fragment {
    Context context = null;
    View rootView;
    //Youtube Listener
    private YouTubePlayer.OnInitializedListener monInitializedListener;
    //declareView
    private YouTubePlayerSupportFragment youtubeFragment;
    private Button playButton;
    private TextView tv;

    public HomeJoinUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home_join_us, container, false);

        tv = rootView.findViewById(R.id.status);
        playButton = rootView.findViewById(R.id.play_button);

        youtubeFragment = (YouTubePlayerSupportFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
        initYoutube();

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtubeFragment.initialize(YoutubeConfig.getYoutubeApiKey(), monInitializedListener);
            }
        });


//            youtubePlayerView=rootView.findViewById(R.id.youtube_player_view);


        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        context = context;
        super.onAttach(context);
    }


    private void initYoutube() {
        monInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                youTubePlayer.cuePlaylist(); this method is ued to laod the whole playlist
                tv.setText("still loading...");
                youTubePlayer.loadVideo("zDo0H8Fm7d0");

                Log.d("tag", "onInitializationSuccess: " + "video has been loaded");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(context, "nahi chal raha bhai", Toast.LENGTH_SHORT).show();
            }
        };


    }
}