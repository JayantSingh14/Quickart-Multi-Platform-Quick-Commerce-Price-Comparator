package com.reactnativepagerview.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class PageScrollEvent extends Event<PageScrollEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final int f46405a;

    /* renamed from: b, reason: collision with root package name */
    public final float f46406b;

    @Metadata
    public static final class Companion {
    }

    public PageScrollEvent(float f2, int i2, int i3) {
        super(i2);
        this.f46405a = i3;
        this.f46406b = (Float.isInfinite(f2) || Float.isNaN(f2)) ? 0.0f : f2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        int viewTag = getViewTag();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("position", this.f46405a);
        writableMapCreateMap.putDouble("offset", this.f46406b);
        rctEventEmitter.receiveEvent(viewTag, "topPageScroll", writableMapCreateMap);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topPageScroll";
    }
}
