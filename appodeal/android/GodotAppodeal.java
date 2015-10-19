package com.android.godot;

public class GodotAppedeal extends Godot.SingletonBase{

  static public Godot.SingletonBase initialize(Activity p_activity)
  {
    return new GodotAppodeal(p_activity);
  }

  public init()
  {
    String appKey = "";
    Appodeal.initialize(this,appKey);
  }
}
