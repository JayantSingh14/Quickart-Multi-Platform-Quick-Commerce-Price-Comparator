package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
public class ReactTextChangedEvent extends Event<ReactTextChangedEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final String f20195a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20196b;

    public ReactTextChangedEvent(int i2, int i3, int i4, String str) {
        super(i2, i3);
        this.f20195a = str;
        this.f20196b = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("text", this.f20195a);
        writableMapCreateMap.putInt("eventCount", this.f20196b);
        writableMapCreateMap.putInt("target", getViewTag());
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topChange";
    }
}
