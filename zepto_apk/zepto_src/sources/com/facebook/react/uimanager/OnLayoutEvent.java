package com.facebook.react.uimanager;

import androidx.core.util.Pools;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

@Nullsafe
/* loaded from: classes.dex */
public class OnLayoutEvent extends Event<OnLayoutEvent> {

    /* renamed from: e, reason: collision with root package name */
    public static final Pools.SynchronizedPool f19419e = new Pools.SynchronizedPool(20);

    /* renamed from: a, reason: collision with root package name */
    public int f19420a;

    /* renamed from: b, reason: collision with root package name */
    public int f19421b;

    /* renamed from: c, reason: collision with root package name */
    public int f19422c;

    /* renamed from: d, reason: collision with root package name */
    public int f19423d;

    public static OnLayoutEvent a(int i2, int i3, int i4, int i5, int i6) {
        OnLayoutEvent onLayoutEvent = (OnLayoutEvent) f19419e.b();
        if (onLayoutEvent == null) {
            onLayoutEvent = new OnLayoutEvent();
        }
        super.init(-1, i2);
        onLayoutEvent.f19420a = i3;
        onLayoutEvent.f19421b = i4;
        onLayoutEvent.f19422c = i5;
        onLayoutEvent.f19423d = i6;
        return onLayoutEvent;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("x", PixelUtil.a(this.f19420a));
        writableMapCreateMap.putDouble("y", PixelUtil.a(this.f19421b));
        writableMapCreateMap.putDouble(Snapshot.WIDTH, PixelUtil.a(this.f19422c));
        writableMapCreateMap.putDouble(Snapshot.HEIGHT, PixelUtil.a(this.f19423d));
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap("layout", writableMapCreateMap);
        writableMapCreateMap2.putInt("target", getViewTag());
        return writableMapCreateMap2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topLayout";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void onDispose() {
        f19419e.a(this);
    }
}
