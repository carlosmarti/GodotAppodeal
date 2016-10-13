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
    _on_banner_loaded()
    
    _on_banner_failed_to_load()
    
    _on_banner_shown()
    
    _on_banner_clicked()
    
    _on_video_loaded()
    
    _on_video_failed_to_load()
    
    _on_video_shown()
    
    _on_video_finished()
    
    _on_video_closed()

    _on_rewarded_video_loaded()

    _on_rewarded_video_failed_to_load()

    _on_rewarded_video_finished(amount, name)
    - integer amount
    - string name

    _on_rewarded_video_closed
    
    
    



Good Luck and Enjoy
