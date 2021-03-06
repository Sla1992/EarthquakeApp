package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public  class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    public EarthquakeLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        Log.e(LOG_TAG, "TEST: EarthquakeLoader onStartLoading() called.");
        forceLoad();
    }


    @Override
    public List<Earthquake> loadInBackground() {
        Log.e(LOG_TAG, "TEST: EarthquakeLoader laodInBackground() called.");

        // Don't perform the request if there are no URLs, or the first URL is null
        if (mUrl == null) {
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
