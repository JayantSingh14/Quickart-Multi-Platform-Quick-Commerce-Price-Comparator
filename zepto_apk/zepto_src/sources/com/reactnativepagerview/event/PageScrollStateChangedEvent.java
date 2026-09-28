package com.reactnativepagerview.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class PageScrollStateChangedEvent extends Event<PageScrollStateChangedEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final String f46407a;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageScrollStateChangedEvent(int i2, String mPageScrollState) {
        super(i2);
        Intrinsics.checkNotNullParameter(mPageScrollState, "mPageScrollState");
        this.f46407a = mPageScrollState;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        int viewTag = getViewTag();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("pageScrollState", this.f46407a);
        rctEventEmitter.receiveEvent(viewTag, "topPageScrollStateChanged", writableMapCreateMap);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topPageScrollStateChanged";
    }
}
