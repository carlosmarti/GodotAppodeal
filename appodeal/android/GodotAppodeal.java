package com.android.godot;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.appodeal.ads.InterstitialCallbacks;
import com.appodeal.ads.VideoCallbacks;
import android.app.Activity;
import android.util.Log;

public class GodotAppodeal extends Godot.SingletonBase
{
    //variable
    private Activity activity = null;
    String appKey = "";
    
    static public Godot.SingletonBase initialize(Activity p_activity) {

		return new GodotAppodeal(p_activity);
	}

    //constructor
    public GodotAppodeal(Activity p_activity)
    {
        //The registratiosion of this and its functions
        registerClass("Appodeal", new String[]{

                "init","showBannerAd","showVideoAd","showInterstitialAd","showInterstitialAndVideoAds","hideBannerAd",
                "hideVideoAd","hideInterstitialAd","isBannerLoaded","isVideoLoaded","isInterstitialLoaded","isAnyAdLoaded"
        });

        activity = p_activity;
    }

    //initialization of appodeal
    public void init(final String key, final String type, final boolean testing = true)
    {
        
        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
				appKey = key;
				Appodeal.disableLocationPermissionCheck();
                //check string to see if it is a test or a normal initialization or a spacific initialization
                if(testing)
                {
                    Appodeal.setTesting(true);
                }
                
                if(type.equals("banner"))
                {
                    Appodeal.initialize(activity, appKey, Appodeal.BANNER);
                }
                else if(type.equals("banner/video"))
                {
                    Appodeal.initialize(activity, appKey, Appodeal.BANNER | Appodeal.VIDEO);
                }
                else if(type.equals("video"))
                {
                    Appodeal.initialize(activity, appKey, Appodeal.VIDEO);
                }
                else if(type.equals("insterstitial"))
                {
                    Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL);
                }
                else if(type.equals("interstitial/video"))
                {
                    Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL | Appodeal.VIDEO);
                }
                else
                {
                    Log.d("godot","Did not find a initialization type for :" + type);
                }
                
            }
        });
    }

    public void showBannerAd(String type)
    {

        if (type.equals("top")) {

            Appodeal.show(activity, Appodeal.BANNER_TOP);
            Log.d("godot","show banner top");
        }
        else if (type.equals("center")) {

            Appodeal.show(activity, Appodeal.BANNER_CENTER);
            Log.d("godot","show banner center");
        }
        else if(type.equals("bottom")) {

            Appodeal.show(activity, Appodeal.BANNER_BOTTOM);
            Log.d("godot","show banner buttom");
        }
        else{
            Log.d("godot","Did not find banner of type :" + type);
        }
    }

    public void showVideoAd()
    {

        Appodeal.show(activity, Appodeal.VIDEO);
        Log.d("godot","show video");

    }

    public void showInterstitialAd()
    {

        Appodeal.show(activity, Appodeal.INTERSTITIAL);
        Log.d("godot","show interstitial");

    }

    public void showInterstitialAndVideoAds()
    {

        Appodeal.show(activity, Appodeal.VIDEO | Appodeal.INTERSTITIAL);
        Log.d("godot","show video and interstitial");

    }

    public void hideBannerAd()
    {

        Appodeal.hide(activity, Appodeal.BANNER);
        Log.d("godot","hide banner");
    }

    public void hideVideoAd()
    {

        Appodeal.hide(activity, Appodeal.VIDEO);
        Log.d("godot","hide video");

    }

    public void hideInterstitialAd()
    {

        Appodeal.hide(activity, Appodeal.INTERSTITIAL);
        Log.d("godot","hide interstitial");
    }

    public boolean isBannerLoaded()
    {
        boolean loaded;

        loaded = Appodeal.isLoaded(Appodeal.BANNER);

        return loaded;
    }

    public boolean isVideoLoaded()
    {
        boolean loaded;

        loaded = Appodeal.isLoaded(Appodeal.VIDEO);

        return loaded;
    }

    public boolean isInterstitialLoaded()
    {
        boolean loaded;

        loaded = Appodeal.isLoaded(Appodeal.INTERSTITIAL);
         
        return loaded;
    }

    public boolean isAnyAdLoaded()
    {
        boolean loaded;
   
        loaded = Appodeal.isLoaded(Appodeal.ANY);
            
        return loaded;
    }
}
