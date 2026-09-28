package com.facebook.react.views.switchview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class ReactSwitchEvent extends Event<ReactSwitchEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20094a;

    @Metadata
    public static final class Companion {
    }

    public ReactSwitchEvent(int i2, int i3, boolean z) {
        super(i2, i3);
        this.f20094a = z;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("target", getViewTag());
        writableMapCreateMap.putBoolean(CLConstants.FIELD_PAY_INFO_VALUE, this.f20094a);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topChange";
    }
}
