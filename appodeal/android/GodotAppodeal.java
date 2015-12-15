package com.android.godot;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.appodeal.ads.InterstitialCallbacks;
import com.appodeal.ads.VideoCallbacks;
import com.appodeal.ads.RewardedVideoCallbacks;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

public class GodotAppodeal extends Godot.SingletonBase
{
    //variable
    private Activity activity = null;
    String appKey = "";
    private int instanceId = 0;
    private boolean testing = true;
    private Toast toast;
    
    static public Godot.SingletonBase initialize(Activity p_activity) {

        return new GodotAppodeal(p_activity);
    }

    //constructor
    public GodotAppodeal(Activity p_activity)
    {
        //The registratiosion of this and its functions
        registerClass("Appodeal", new String[]{

                "init","showBannerAd","showVideoAd","showInterstitialAd","showInterstitialAndVideoAds","hideBannerAd",
                "hideVideoAd","hideInterstitialAd","isBannerLoaded","isVideoLoaded","isInterstitialLoaded","isAnyAdLoaded",
                "isRewardedVideoLoaded", "showRewardedVideoAd" 
        });

        activity = p_activity;
    }

    //initialization of appodeal
    public void init(final int new_instanceId, final String key, final String type, final boolean is_testing)
    {        
        instanceId = new_instanceId;
        testing = is_testing;
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
                else if(type.equals("rewardedvideo"))
                {
                    Appodeal.initialize(activity, appKey, Appodeal.REWARDED_VIDEO);
                }
                else if(type.equals("banner/rewardedvideo"))
                {
                    Appodeal.initialize(activity, appKey, Appodeal.BANNER | Appodeal.REWARDED_VIDEO);
                }
                else
                {
                    Log.d("godot","Did not find a initialization type for :" + type);
                }   

                enableCallBacks();
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

    public void showRewardedVideoAd()
    {
        Appodeal.show(activity, Appodeal.REWARDED_VIDEO);
        Log.d("godot","show rewarded video");
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

    public boolean isRewardedVideoLoaded()
    {
        boolean loaded;
        loaded = Appodeal.isLoaded(Appodeal.REWARDED_VIDEO);
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


    private void enableCallBacks()
    {

        Appodeal.setBannerCallbacks(new BannerCallbacks() {
            @Override
            public void onBannerLoaded() {
               showToastOnTesting("onBannerLoaded");
               GodotLib.calldeferred(instanceId, "_on_banner_loaded", new Object[]{});
            }

            @Override
            public void onBannerFailedToLoad() {
                showToastOnTesting("onBannerFailedToLoad");
                GodotLib.calldeferred(instanceId, "_on_banner_failed_to_load", new Object[]{});
            }

            @Override
            public void onBannerShown() {
                showToastOnTesting("onBannerShown");
                GodotLib.calldeferred(instanceId, "_on_banner_shown", new Object[]{});
            }

            @Override
            public void onBannerClicked() {
                showToastOnTesting("onBannerClicked");
                GodotLib.calldeferred(instanceId, "_on_banner_clicked", new Object[]{});
            }
        });


        Appodeal.setVideoCallbacks(new VideoCallbacks() {
            @Override
            public void onVideoLoaded() {
                showToastOnTesting("onVideoLoaded");
                GodotLib.calldeferred(instanceId, "_on_video_loaded", new Object[]{});
            }

            @Override
            public void onVideoFailedToLoad() {
                showToastOnTesting("onVideoFailedToLoad");
                GodotLib.calldeferred(instanceId, "_on_video_failed_to_load", new Object[]{});
            }

            @Override
            public void onVideoShown() {
                showToastOnTesting("onVideoShown");
                GodotLib.calldeferred(instanceId, "_on_video_shown", new Object[]{});
            }

            @Override
            public void onVideoFinished() {
                showToastOnTesting("onVideoFinished");
                GodotLib.calldeferred(instanceId, "_on_video_finished", new Object[]{});
            }

            @Override
            public void onVideoClosed() {
                showToastOnTesting("onVideoClosed");
                GodotLib.calldeferred(instanceId, "_on_video_closed", new Object[]{});
            }
        });

        Appodeal.setRewardedVideoCallbacks(new RewardedVideoCallbacks() {
            @Override
            public void onRewardedVideoLoaded() {
                showToastOnTesting("onRewardedVideoLoaded");
                GodotLib.calldeferred(instanceId, "_on_rewarded_video_loaded", new Object[]{});
            }

            @Override
            public void onRewardedVideoFailedToLoad() {
                showToastOnTesting("onRewardedVideoFailedToLoad");
                GodotLib.calldeferred(instanceId, "_on_rewarded_video_failed_to_load", new Object[]{});
            }

            @Override
            public void onRewardedVideoShown() {
                showToastOnTesting("onRewardedVideoShown");
                GodotLib.calldeferred(instanceId, "_on_rewarded_video_shown", new Object[]{});
            }

            @Override
            public void onRewardedVideoFinished(int amount, String name) {
                showToastOnTesting(String.format("onRewardedVideoFinished. Reward: %d %s", amount, name));
                GodotLib.calldeferred(instanceId, "_on_rewarded_video_finished", new Object[]{amount, name});
            }

            @Override
            public void onRewardedVideoClosed() {
                showToastOnTesting("onRewardedVideoClosed");
                GodotLib.calldeferred(instanceId, "_on_rewarded_video_closed", new Object[]{});
            }
        });
    }  

    private void showToastOnTesting(final String text) {
        if (!testing) {
            return;
        }

        if (toast == null) {
            toast = Toast.makeText(activity, text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

}