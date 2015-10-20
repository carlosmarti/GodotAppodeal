package com.android.godot;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.appodeal.ads.InterstitialCallbacks;
import com.appodeal.ads.VideoCallbacks;
import android.app.Activity;
import android.util.Log;

public class GodotAppedeal extends Godot.SingletonBase
{
    //variable
    private Activity activity = null;

    static public Godot.SingletonBase initialize(Activity p_activity)
    {
        return new GodotAppodeal(p_activity);
    }

    //constructor
    public void GodotAppodeal(Activity p_activity)
    {
        //The registratiosion of this and its functions
        registerClass("Appodeal", new String[]{

                "init","showBannerAd","showVideoAd","showInterstitialAd","showInterstitialAndVideoAds","hideBannerAd",
                "hideVideoAd","hideInterstitialAd","isBannerLoaded","isVideoLoaded","isInterstitialLoaded","isAnyAdLoaded"
        });

        activity = p_activity;
    }

    //initialization of appodeal
    public void init(String key,String type)
    {
        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                //check string to see if it is a test or a normal initialization or a spacific initialization
                switch (type) {

                    case "test":
                        Appodeal.setTesting(true);
                        String appKey = key;
                        Appodeal.initialize(this, appKey);
                        break;
                    case "normal":
                        String appKey = key;
                        Appodeal.initialize(this, appKey);
                        break;
                    case "banner":
                        String appKey = key;
                        Appodeal.initialize(this, appKey, Appodeal.BANNER);
                        break;
                    case "video":
                        String appKey = key;
                        Appodeal.initialize(this, appKey, Appodeal.VIDEO);
                        break;
                    case "interstitial":
                        String appKey = key;
                        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL);
                        break;
                    case "interstitial&video":
                        String appKey = key;
                        Appodeal.initialize(this, appKey, Appodeal.INTERSTITIAL | Appodeal.VIDEO);
                        break;
                    default:
                        Log.d("godot","Did not find a initialization type for :" + type);
                        break;
                }
            }
        });
    }

    public void showBannerAd(String type)
    {

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {

                if (type == "top") {

                    Appodeal.show(this, Appodeal.BANNER_TOP);
                    Log.d("godot","show banner top");
                }
                else if (type == "center") {

                    Appodeal.show(this, Appodeal.BANNER_CENTER);
                    Log.d("godot","show banner center");
                }
                else if(type == "buttom") {

                    Appodeal.show(this, Appodeal.BANNER_BUTTOM);
                    Log.d("godot","show banner buttom");
                }
                else{
                    Log.d("godot","Did not find banner of type :" + type);
                }
            }
        });
    }

    public void showVideoAd()
    {

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
                Appodeal.show(this, Appodeal.VIDEO);
                Log.d("godot","show video");
            }

        });
    }

    public void showInterstitialAd()
    {

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
                Appodeal.show(this, Appodeal.INTERSTITIAL);
                Log.d("godot","show interstitial");
            }

        });
    }

    public void showInterstitialAndVideoAds()
    {

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
                Appodeal.show(this, Appodeal.VIDEO | Appodeal.INTERSTITIAL);
                Log.d("godot","show video and interstitial");
            }

        });
    }

    public void hideBannerAd()
    {

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
                Appodeal.hide(this, Appodeal.BANNER);
                Log.d("godot","hide banner");
            }

        });
    }

    public void hideVideoAd()
    {

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
                Appodeal.hide(this, Appodeal.VIDEO);
                Log.d("godot","hide video");
            }

        });
    }

    public void hideInterstitialAd()
    {

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
               Appodeal.hide(this, Appodeal.INTERSTITIAL);
               Log.d("godot","hide interstitial");
            }

        });
    }

    public boolean isBannerLoaded()
    {
        boolean loaded;

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
              loaded = Appodeal.isLoaded(Appdeal.BANNER);
            }
        });

        return loaded;
    }

    public boolean isVideoLoaded()
    {
        boolean loaded;

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
               loaded = Appodeal.isLoaded(Appdeal.VIDEO);
            }
        });

        return loaded;
    }

    public boolean isInterstitialLoaded()
    {
        boolean loaded;

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
              loaded = Appodeal.isLoaded(Appdeal.INTERSTITIAL);
            }
        });

        return loaded;
    }

    public boolean isAnyAdLoaded()
    {
        boolean loaded;

        activity.runOnUiThread(new Runnable()
        {

            @Override
            public void run()
            {
                loaded = Appodeal.isLoaded(Appdeal.ANY);
            }
        });

        return loaded;
    }
}
