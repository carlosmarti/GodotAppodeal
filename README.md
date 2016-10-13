 GodotAppodeal
==================
  Appodeal Ads Module for Godot engine

How to Use
-------------
Simply clone this repository put inside of the modules folder inside of godot source code and compile the godot source for android.

Avaliable Functions:
---------------------
    appodeal.init(instanceId, key, type, testing)
    - integer instanceId => use get_instance_ID()
    - string key => your appodeal key
    - string type => valid values: "banner", "video", "interstitial", "interstitial/video", "banner/video", "rewardedvideo", "banner/rewardedvideo", "banner/interstitial"
    - boolean testing => indicates if you are testing your app or not
    
    appodeal.showBannerAd(type)
    - string type => This function requires a banner type of the following ("top", "center", "bottom")
    
    appodeal.showVideoAd()
    
    appodeal.showRewardedVideoAd()

    appodeal.showInterstitialAd()
    
    appodeal.showInterstitialAndVideoAds()
    
    appodeal.loadNonSkipVideoAd()
    
    appodeal.loadBannerAd()
    
    appodeal.loadInterstitialVideoAd()
    
    appodeal.loadRewardedVideoAd()
    
    appodeal.loadVideoAd()
    
    appodeal.hideBannerAd()
    
    appodeal.hideVideoAd()
    
    appodeal.hideInterstitalAd()
    
    appodeal.isBannerLoaded() Boolean
    
    appodeal.isVideoLoaded() Boolean

    appodeal.isRewardedVideoLoaded() Boolean
    
    appodeal.isInterstitalLoaded() Boolean
    
    appodeal.isAnyAdLoaded() Boolean
    
    appodeal.registerCallback()
    
    appodeal.unRegisterCallback()
    


Callback Functions:
---------------------

You should register your gdscript callbacks functions with registerCallback before use.
Ex:
    
    (...)
    appodeal.registerCallback("onInterstitialLoaded", "_my_callback")
    (...)

    func _my_callback():
        print ("Interstitial was loaded")
      


    appodeal.registerCallback(callback_type, callback_function)
    - string callback_type => valid values: 

            "onInterstitialLoaded"
            "onInterstitialFailedToLoad"
            "onInterstitialShown"
            "onInterstitialClicked"
            "onInterstitialClosed"

            "onBannerLoaded"
            "onBannerFailedToLoad"
            "onBannerShown"
            "onBannerClicked"

            "onSkippableVideoLoaded"
            "onSkippableVideoFailedToLoad"
            "onSkippableVideoShown"
            "onSkippableVideoFinished"

            "onSkippableVideoClosed"
            "onNonSkippableVideoLoaded"
            "onNonSkippableVideoFailedToLoad"
            "onNonSkippableVideoShown"
            "onNonSkippableVideoFinished"
            "onNonSkippableVideoClosed"

            "onRewardedVideoLoaded"
            "onRewardedVideoFailedToLoad"
            "onRewardedVideoShown"
            "onRewardedVideoFinished"
            "onRewardedVideoClosed"

    - string callback_function => the name of your callback function

    appodeal.unregisterCallback(callback_type)
    - string callback_type => valid values: same as in registerCallback




Good Luck and Enjoy
