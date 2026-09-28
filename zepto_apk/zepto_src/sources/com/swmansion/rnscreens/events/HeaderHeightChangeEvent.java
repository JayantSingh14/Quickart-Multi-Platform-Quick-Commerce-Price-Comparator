package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class HeaderHeightChangeEvent extends Event<HeaderHeightChangeEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final int f47115a;

    @Metadata
    public static final class Companion {
    }

    public HeaderHeightChangeEvent(int i2, int i3, int i4) {
        super(i2, i3);
        this.f47115a = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) this.f47115a;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("headerHeight", this.f47115a);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topHeaderHeightChange";
    }
}
