package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class OnAnimationLoadedEvent extends Event<OnAnimationLoadedEvent> {

    @Metadata
    public static final class Companion {
    }

    public OnAnimationLoadedEvent(int i2, int i3) {
        super(i2, i3);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        return Arguments.createMap();
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topAnimationLoaded";
    }
}
