package com.facebook.react.views.modal;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ShowEvent extends Event<ShowEvent> {

    @Metadata
    public static final class Companion {
    }

    public ShowEvent(int i2, int i3) {
        super(i2, i3);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        return Arguments.createMap();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topShow";
    }
}
