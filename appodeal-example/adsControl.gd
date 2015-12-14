
extends Node

# member variables here, example:
# var a=2
# var b="textvar"
var numOfDeaths = 0
var videoShown = false
func _ready():
	# Initialization here
	pass

func characterDied(death):
	numOfDeaths += death
	if(numOfDeaths > 4):
		get_node("/root/ads").showInterstitialAd()
		numOfDeaths = 0

func videoShowed():
	videoShown = true

func hasVideoBeenShown():
	return videoShown