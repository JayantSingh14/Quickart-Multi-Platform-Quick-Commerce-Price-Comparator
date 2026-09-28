package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class ScreenTransitionProgressEvent extends Event<ScreenTransitionProgressEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final float f47130a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f47131b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f47132c;

    /* renamed from: d, reason: collision with root package name */
    public final short f47133d;

    @Metadata
    public static final class Companion {
    }

    public ScreenTransitionProgressEvent(int i2, int i3, float f2, boolean z, boolean z2, short s) {
        super(i2, i3);
        this.f47130a = f2;
        this.f47131b = z;
        this.f47132c = z2;
        this.f47133d = s;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return this.f47133d;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(ReactProgressBarViewManager.PROP_PROGRESS, this.f47130a);
        writableMapCreateMap.putInt("closing", this.f47131b ? 1 : 0);
        writableMapCreateMap.putInt("goingForward", this.f47132c ? 1 : 0);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topTransitionProgress";
    }
}
