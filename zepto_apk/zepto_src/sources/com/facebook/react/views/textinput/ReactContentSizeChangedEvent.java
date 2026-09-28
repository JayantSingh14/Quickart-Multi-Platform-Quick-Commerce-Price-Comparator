package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

/* loaded from: classes3.dex */
public class ReactContentSizeChangedEvent extends Event<ReactTextChangedEvent> {

    /* renamed from: a, reason: collision with root package name */
    public float f20179a;

    /* renamed from: b, reason: collision with root package name */
    public float f20180b;

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble(Snapshot.WIDTH, this.f20179a);
        writableMapCreateMap2.putDouble(Snapshot.HEIGHT, this.f20180b);
        writableMapCreateMap.putMap("contentSize", writableMapCreateMap2);
        writableMapCreateMap.putInt("target", getViewTag());
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topContentSizeChange";
    }
}
