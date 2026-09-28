package com.reactnativecommunity.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class ReactSliderEvent extends Event<ReactSliderEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final double f46224a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f46225b;

    public ReactSliderEvent(int i2, double d2) {
        super(i2);
        this.f46224a = d2;
        this.f46225b = true;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("target", getViewTag());
        writableMapCreateMap.putDouble(CLConstants.FIELD_PAY_INFO_VALUE, this.f46224a);
        writableMapCreateMap.putBoolean("fromUser", this.f46225b);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topChange";
    }
}
