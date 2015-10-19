def can_build(plat):
    return plat == "android"

def configure(env):
    env.android_module_file("android/GodotAppodeal.java")
    env.android_module_manifest("android/AndroidManifestChunk.xml")
    env.android_module_library("android/sdk/android-support-v4-22.2.1.jar")
    env.android_module_library("android/sdk/applovin-sdk-6.0.1.jar")
    env.android_module_library("android/sdk/appodeal-1.13.1.jar")
    env.android_module_library("android/sdk/chartboost-5.2.0.jar")
    env.android_module_library("android/sdk/my-target-4.0.13.jar")
    env.android_module_library("android/sdk/unity-ads-1.4.7.jar")
    env.android_module_library("android/sdk/google-play-services")
