package com.facebook.react.views.scroll;

import android.os.SystemClock;
import androidx.core.util.Pools;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.scroll.ScrollEventType;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ScrollEvent extends Event<ScrollEvent> {

    /* renamed from: k, reason: collision with root package name */
    public static final Pools.SynchronizedPool f20072k = new Pools.SynchronizedPool(3);

    /* renamed from: a, reason: collision with root package name */
    public float f20073a;

    /* renamed from: b, reason: collision with root package name */
    public float f20074b;

    /* renamed from: c, reason: collision with root package name */
    public float f20075c;

    /* renamed from: d, reason: collision with root package name */
    public float f20076d;

    /* renamed from: e, reason: collision with root package name */
    public int f20077e;

    /* renamed from: f, reason: collision with root package name */
    public int f20078f;

    /* renamed from: g, reason: collision with root package name */
    public int f20079g;

    /* renamed from: h, reason: collision with root package name */
    public int f20080h;

    /* renamed from: i, reason: collision with root package name */
    public ScrollEventType f20081i;

    /* renamed from: j, reason: collision with root package name */
    public long f20082j;

    @Metadata
    public static final class Companion {
        public static ScrollEvent a(int i2, int i3, ScrollEventType scrollEventType, float f2, float f3, float f4, float f5, int i4, int i5, int i6, int i7) {
            ScrollEvent scrollEvent = (ScrollEvent) ScrollEvent.f20072k.b();
            if (scrollEvent == null) {
                scrollEvent = new ScrollEvent();
            }
            ScrollEvent scrollEvent2 = scrollEvent;
            ScrollEvent.a(scrollEvent2, i2, i3, scrollEventType, f2, f3, f4, f5, i4, i5, i6, i7);
            return scrollEvent2;
        }
    }

    public static final void a(ScrollEvent scrollEvent, int i2, int i3, ScrollEventType scrollEventType, float f2, float f3, float f4, float f5, int i4, int i5, int i6, int i7) {
        super.init(i2, i3);
        scrollEvent.f20081i = scrollEventType;
        scrollEvent.f20073a = f2;
        scrollEvent.f20074b = f3;
        scrollEvent.f20075c = f4;
        scrollEvent.f20076d = f5;
        scrollEvent.f20077e = i4;
        scrollEvent.f20078f = i5;
        scrollEvent.f20079g = i6;
        scrollEvent.f20080h = i7;
        scrollEvent.f20082j = SystemClock.uptimeMillis();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        return this.f20081i == ScrollEventType.f20086d;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("top", 0.0d);
        writableMapCreateMap.putDouble("bottom", 0.0d);
        writableMapCreateMap.putDouble("left", 0.0d);
        writableMapCreateMap.putDouble("right", 0.0d);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("x", PixelUtil.a(this.f20073a));
        writableMapCreateMap2.putDouble("y", PixelUtil.a(this.f20074b));
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putDouble(Snapshot.WIDTH, PixelUtil.a(this.f20077e));
        writableMapCreateMap3.putDouble(Snapshot.HEIGHT, PixelUtil.a(this.f20078f));
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putDouble(Snapshot.WIDTH, PixelUtil.a(this.f20079g));
        writableMapCreateMap4.putDouble(Snapshot.HEIGHT, PixelUtil.a(this.f20080h));
        WritableMap writableMapCreateMap5 = Arguments.createMap();
        writableMapCreateMap5.putDouble("x", this.f20075c);
        writableMapCreateMap5.putDouble("y", this.f20076d);
        WritableMap writableMapCreateMap6 = Arguments.createMap();
        writableMapCreateMap6.putMap("contentInset", writableMapCreateMap);
        writableMapCreateMap6.putMap("contentOffset", writableMapCreateMap2);
        writableMapCreateMap6.putMap("contentSize", writableMapCreateMap3);
        writableMapCreateMap6.putMap("layoutMeasurement", writableMapCreateMap4);
        writableMapCreateMap6.putMap("velocity", writableMapCreateMap5);
        writableMapCreateMap6.putInt("target", getViewTag());
        writableMapCreateMap6.putDouble("timestamp", this.f20082j);
        writableMapCreateMap6.putBoolean("responderIgnoreScroll", true);
        return writableMapCreateMap6;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        ScrollEventType.Companion companion = ScrollEventType.f20083a;
        ScrollEventType scrollEventType = this.f20081i;
        Assertions.c(scrollEventType);
        Intrinsics.checkNotNullExpressionValue(scrollEventType, "assertNotNull(...)");
        companion.getClass();
        return ScrollEventType.Companion.a(scrollEventType);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void onDispose() {
        try {
            f20072k.a(this);
        } catch (IllegalStateException e2) {
            Intrinsics.checkNotNullExpressionValue("ScrollEvent", "TAG");
            ReactSoftExceptionLogger.logSoftException("ScrollEvent", e2);
        }
    }
}
