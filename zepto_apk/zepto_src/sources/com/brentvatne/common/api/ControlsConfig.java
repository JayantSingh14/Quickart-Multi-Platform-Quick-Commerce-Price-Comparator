package com.brentvatne.common.api;

import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ControlsConfig {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15369a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15370b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15371c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15372d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15373e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15374f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15375g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15376h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f15377i;

    /* renamed from: l, reason: collision with root package name */
    public String f15380l;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15378j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15379k = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15381m = true;
    public int n = 10000;

    @Metadata
    public static final class Companion {
        public static ControlsConfig a(ReadableMap readableMap) {
            ControlsConfig controlsConfig = new ControlsConfig();
            if (readableMap != null) {
                controlsConfig.f15369a = ReactBridgeUtils.b(readableMap, "hideSeekBar", false);
                controlsConfig.f15370b = ReactBridgeUtils.b(readableMap, "hideDuration", false);
                controlsConfig.f15371c = ReactBridgeUtils.b(readableMap, "hidePosition", false);
                controlsConfig.f15372d = ReactBridgeUtils.b(readableMap, "hidePlayPause", false);
                controlsConfig.f15373e = ReactBridgeUtils.b(readableMap, "hideForward", false);
                controlsConfig.f15374f = ReactBridgeUtils.b(readableMap, "hideRewind", false);
                controlsConfig.f15375g = ReactBridgeUtils.b(readableMap, "hideNext", false);
                controlsConfig.f15376h = ReactBridgeUtils.b(readableMap, "hidePrevious", false);
                controlsConfig.f15377i = ReactBridgeUtils.b(readableMap, "hideFullscreen", false);
                controlsConfig.n = ReactBridgeUtils.e(10000, "seekIncrementMS", readableMap);
                controlsConfig.f15378j = ReactBridgeUtils.b(readableMap, "hideNavigationBarOnFullScreenMode", true);
                controlsConfig.f15379k = ReactBridgeUtils.b(readableMap, "hideNotificationBarOnFullScreenMode", true);
                controlsConfig.f15380l = ReactBridgeUtils.h(readableMap, "liveLabel", null);
                controlsConfig.f15381m = ReactBridgeUtils.b(readableMap, "hideSettingButton", true);
            }
            return controlsConfig;
        }
    }

    public final boolean a() {
        return this.f15370b;
    }

    public final boolean b() {
        return this.f15373e;
    }

    public final boolean c() {
        return this.f15377i;
    }

    public final boolean d() {
        return this.f15375g;
    }

    public final boolean e() {
        return this.f15372d;
    }

    public final boolean f() {
        return this.f15371c;
    }

    public final boolean g() {
        return this.f15376h;
    }

    public final boolean h() {
        return this.f15374f;
    }

    public final boolean i() {
        return this.f15369a;
    }

    public final boolean j() {
        return this.f15381m;
    }

    public final String k() {
        return this.f15380l;
    }
}
