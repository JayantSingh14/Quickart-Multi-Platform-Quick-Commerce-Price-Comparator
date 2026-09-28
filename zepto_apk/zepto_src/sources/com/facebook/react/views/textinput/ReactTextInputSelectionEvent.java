package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
class ReactTextInputSelectionEvent extends Event<ReactTextInputSelectionEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final int f20225a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20226b;

    public ReactTextInputSelectionEvent(int i2, int i3, int i4, int i5) {
        super(i2, i3);
        this.f20225a = i4;
        this.f20226b = i5;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putInt("end", this.f20226b);
        writableMapCreateMap2.putInt("start", this.f20225a);
        writableMapCreateMap.putMap("selection", writableMapCreateMap2);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topSelectionChange";
    }
}
