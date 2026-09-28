package com.reactnativecommunity.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class ReactSlidingStartEvent extends Event<ReactSlidingStartEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final double f46227a;

    public ReactSlidingStartEvent(int i2, double d2) {
        super(i2);
        this.f46227a = d2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("target", getViewTag());
        writableMapCreateMap.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, this.f46227a);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "onRNCSliderSlidingStart";
    }
}
