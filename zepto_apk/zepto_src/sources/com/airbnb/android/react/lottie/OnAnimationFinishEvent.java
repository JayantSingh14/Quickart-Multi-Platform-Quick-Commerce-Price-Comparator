package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class OnAnimationFinishEvent extends Event<OnAnimationFinishEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14094a;

    @Metadata
    public static final class Companion {
    }

    public OnAnimationFinishEvent(int i2, int i3, boolean z) {
        super(i2, i3);
        this.f14094a = z;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean("isCancelled", this.f14094a);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topAnimationFinish";
    }
}
