def can_build(plat):
	return plat=="android"

def configure(env):
	if (env['platform'] == 'android'):
		env.android_add_java_dir("android/src")
		env.android_add_to_manifest("android/AndroidManifestChunk.xml")
		env.android_add_dependency("compile 'com.google.android.gms:play-services-ads:8.4.0'")
		env.android_add_dependency("compile fileTree(dir: '../../../modules/appodeal/android/libs', include: '*.jar')")
