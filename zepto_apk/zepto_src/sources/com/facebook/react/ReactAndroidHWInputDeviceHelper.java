package com.facebook.react;

import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import java.util.HashMap;

/* loaded from: classes.dex */
class ReactAndroidHWInputDeviceHelper {

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f18442c;

    /* renamed from: a, reason: collision with root package name */
    public int f18443a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final ReactRootView f18444b;

    static {
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b(23, "select");
        builderA.b(66, "select");
        builderA.b(62, "select");
        builderA.b(85, "playPause");
        builderA.b(89, "rewind");
        builderA.b(90, "fastForward");
        builderA.b(86, "stop");
        builderA.b(87, "next");
        builderA.b(88, "previous");
        builderA.b(19, "up");
        builderA.b(22, "right");
        builderA.b(20, "down");
        builderA.b(21, "left");
        builderA.b(165, "info");
        builderA.b(82, "menu");
        f18442c = builderA.a();
    }

    public ReactAndroidHWInputDeviceHelper(ReactRootView reactRootView) {
        this.f18444b = reactRootView;
    }

    public final void a(int i2, int i3, String str) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("eventType", str);
        writableNativeMap.putInt("eventKeyAction", i3);
        if (i2 != -1) {
            writableNativeMap.putInt("tag", i2);
        }
        this.f18444b.m("onHWKeyEvent", writableNativeMap);
    }
}
