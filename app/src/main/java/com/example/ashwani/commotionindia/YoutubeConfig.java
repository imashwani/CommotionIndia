package com.example.ashwani.commotionindia;

public class YoutubeConfig {
    private static final String YOUTUBE_API_KEY = "AIzaSyB3PykS5VflaWqDu57TWioMdWE71T_7NBA".trim();

    public YoutubeConfig() {

    }

    public static String getYoutubeApiKey() {
        return YOUTUBE_API_KEY;
    }
}
