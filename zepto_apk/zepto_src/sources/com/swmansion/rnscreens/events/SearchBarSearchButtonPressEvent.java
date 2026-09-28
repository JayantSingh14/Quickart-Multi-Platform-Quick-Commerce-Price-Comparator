package com.swmansion.rnscreens.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class SearchBarSearchButtonPressEvent extends Event<SearchBarSearchButtonPressEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final String f47135a;

    @Metadata
    public static final class Companion {
    }

    public SearchBarSearchButtonPressEvent(int i2, int i3, String str) {
        super(i2, i3);
        this.f47135a = str;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("text", this.f47135a);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topSearchButtonPress";
    }
}
