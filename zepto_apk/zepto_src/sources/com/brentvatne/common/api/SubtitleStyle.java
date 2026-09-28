package com.brentvatne.common.api;

import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class SubtitleStyle {

    /* renamed from: b, reason: collision with root package name */
    public int f15410b;

    /* renamed from: c, reason: collision with root package name */
    public int f15411c;

    /* renamed from: d, reason: collision with root package name */
    public int f15412d;

    /* renamed from: a, reason: collision with root package name */
    public int f15409a = -1;

    /* renamed from: e, reason: collision with root package name */
    public float f15413e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15414f = true;

    @Metadata
    public static final class Companion {
        public static SubtitleStyle a(ReadableMap readableMap) {
            SubtitleStyle subtitleStyle = new SubtitleStyle();
            subtitleStyle.f15409a = ReactBridgeUtils.e(-1, "fontSize", readableMap);
            subtitleStyle.f15412d = ReactBridgeUtils.e(0, "paddingBottom", readableMap);
            subtitleStyle.f15411c = ReactBridgeUtils.e(0, "paddingTop", readableMap);
            subtitleStyle.f15410b = ReactBridgeUtils.e(0, "paddingLeft", readableMap);
            ReactBridgeUtils.e(0, "paddingRight", readableMap);
            subtitleStyle.f15413e = ReactBridgeUtils.d(readableMap, "opacity", 1.0f);
            subtitleStyle.f15414f = ReactBridgeUtils.b(readableMap, "subtitlesFollowVideo", true);
            return subtitleStyle;
        }
    }
}
