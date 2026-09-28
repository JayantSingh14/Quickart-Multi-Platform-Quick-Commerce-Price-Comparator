package com.reactnativecommunity.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class TopShouldStartLoadWithRequestEvent extends Event<TopShouldStartLoadWithRequestEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final WritableMap f46324a;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopShouldStartLoadWithRequestEvent(int i2, WritableMap mData) {
        super(i2);
        Intrinsics.checkNotNullParameter(mData, "mData");
        this.f46324a = mData;
        mData.putString("navigationType", "other");
        mData.putBoolean("isTopFrame", true);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        rctEventEmitter.receiveEvent(getViewTag(), "topShouldStartLoadWithRequest", this.f46324a);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topShouldStartLoadWithRequest";
    }
}
