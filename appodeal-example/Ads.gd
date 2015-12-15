
extends Node

# member variables here, example:
# var a=2
# var b="textvar"
var appodeal = null
var key = null

func _ready():
	# Initialization here
	if(Globals.has_singleton("Appodeal")):
		key = "your key"
		appodeal = Globals.get_singleton("Appodeal")
		appodeal.init(get_instance_ID(), key, "add your ad type here", true)

func showBannerAd(type):
	appodeal.showBannerAd(type)

func showVideoAd():
	appodeal.showVideoAd()

func showInterstitialAd(): 
	appodeal.showInterstitialAd()

func showInterstitialAndVideoAds():
	appodeal.showInterstitialAndVideoAds()

func hideBannerAd():
	appodeal.hideBannerAd()

func hideVideoAd():
	appodeal.hideVideoAd()

func hideInterstitialAd():
	appodeal.hideInterstitialAd()

func isBannerLoaded():
	return appodeal.isBannerLoaded()

func isVideoLoaded():
	return appodeal.isVideoLoaded()

func isInterstitialLoaded():
	return appodeal.isInterstitialLoaded()

func isAnyAdLoaded():
	return appodeal.isAnyAdLoaded()
