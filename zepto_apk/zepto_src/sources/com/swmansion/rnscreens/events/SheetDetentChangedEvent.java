package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class SheetDetentChangedEvent extends Event<SheetDetentChangedEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final int f47136a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f47137b;

    @Metadata
    public static final class Companion {
    }

    public SheetDetentChangedEvent(int i2, int i3, int i4, boolean z) {
        super(i2, i3);
        this.f47136a = i4;
        this.f47137b = z;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("index", this.f47136a);
        writableMapCreateMap.putBoolean("isStable", this.f47137b);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topSheetDetentChanged";
    }
}
