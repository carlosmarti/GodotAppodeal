
extends Node2D

# member variables here, example:
# var a=2
# var b="textvar"
var ads
func _ready():
	# Initialization here
	ads = get_node("/root/ads")
	ads.showBannerAd("top")
	# or
	ads.showInterstitialAndVideoAds()
	#or 
	ads.showInterstitialAd()
	#or
	ads.showVideoAd()


