 GodotAppodeal
==================
  Appodeal Ads Module for Godot engine

How to Use
-------------
Simply clone this repository put inside of the modules folder inside of godot source code and compile the godot source for android.

Avaliable Functions:
---------------------
    appodeal.init(key, type, adType) (type = test,normal) (adType = banner,video,interstitial,interstitial/video,everything)
    
    appodeal.showBannerAd(type) This function requeres a banner type of the following (top, center, bottom)
    
    appodeal.showVideoAd()
    
    appodeal.showInterstitialAd()
    
    appodeal.showInterstitialAndVideoAds()
    
    appodeal.hideBannerAd()
    
    appodeal.hideVideoAd()
    
    appodeal.hideInterstitalAd()
    
    appodeal.isBannerLoaded() Boolean
    
    appodeal.isVideoLoaded() Boolean
    
    appodeal.isInterstitalLoaded() Boolean
    
    appodeal.isAnyAdLoaded() Boolean

Good Luck and Enjoy
