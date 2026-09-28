package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
class ReactTextInputEndEditingEvent extends Event<ReactTextInputEndEditingEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final String f20197a;

    public ReactTextInputEndEditingEvent(int i2, int i3, String str) {
        super(i2, i3);
        this.f20197a = str;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("target", getViewTag());
        writableMapCreateMap.putString("text", this.f20197a);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topEndEditing";
    }
}
