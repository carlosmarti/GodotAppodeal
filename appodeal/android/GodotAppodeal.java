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
    public void init(final String key, final String type, final String adType)
    {
        
        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                //check string to see if it is a test or a normal initialization or a spacific initialization
                if(type.equals("test"))
                {
                    if(adType.equals("banner"))
                    {
                        Appodeal.setTesting(true);
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.BANNER);
                    }
                    else if(adType.equals("banner/video"))
                    {
                        Appodeal.setTesting(true);
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.BANNER | Appodeal.VIDEO);
                    }
                    else if(adType.equals("video"))
                    {
                        Appodeal.setTesting(true);
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.VIDEO);
                    }
                    else if(adType.equals("insterstitial"))
                    {
                        Appodeal.setTesting(true);
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL);
                    }
                    else if(adType.equals("interstitial/video"))
                    {
                        Appodeal.setTesting(true);
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL | Appodeal.VIDEO);
                    }
                    else if(adType.equals("everything"))
                    {
                        Appodeal.setTesting(true);
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL | Appodeal.VIDEO | Appodeal.BANNER);
                    }
                    else
                    {
                        Log.d("godot","Did not find a initialization adType for :" + type);
                    }
                }
                else if(type.equals("normal"))
                {
                    if(adType.equals("banner"))
                    {
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.BANNER);
                    }
                    else if(adType.equals("banner/video"))
                    {
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.BANNER | Appodeal.VIDEO);
                    }
                    else if(adType.equals("video"))
                    {
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.VIDEO);
                    }
                    else if(adType.equals("insterstitial"))
                    {
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL);
                    }
                    else if(adType.equals("interstitial/video"))
                    {
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL | Appodeal.VIDEO);
                    }
                    else if(adType.equals("everything"))
                    {
                        appKey = key;
                        Appodeal.initialize(activity, appKey, Appodeal.INTERSTITIAL | Appodeal.VIDEO | Appodeal.BANNER);
                    }
                    else
                    {
                        Log.d("godot","Did not find a initialization adType for :" + type);
                    }
                }
                else
                {
                    Log.d("godot","Did not find a initialization type for :" + type);
                }
                
            }
        });
    }

    public void showBannerAd( String type)
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
