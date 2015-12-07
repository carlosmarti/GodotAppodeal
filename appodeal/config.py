def can_build(plat):
    return plat == "android"

def configure(env):
    env.android_module_file("android/GodotAppodeal.java")
    env.android_module_manifest("android/AndroidManifestChunk.xml")
    env.android_module_library("android/sdk/android-support-v4-22.2.1.jar")
    env.android_module_library("android/sdk/applovin-6.1.4.jar")
    env.android_module_library("android/sdk/appodeal-1.13.10.jar")
    env.android_module_library("android/sdk/chartboost-6.0.2.jar")
    env.android_module_library("android/sdk/my-target-4.1.2.jar")
    env.android_module_library("android/sdk/unity-ads-1.4.7.jar")
    env.android_module_library("android/sdk/inmobi-5.0.1.jar")
    env.android_module_library("android/sdk/yandex-metrica-android-2.00.jar")
