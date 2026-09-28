package com.airbnb.android.react.lottie;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class OnAnimationFailureEvent extends Event<OnAnimationFailureEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f14093a;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnAnimationFailureEvent(int i2, int i3, Throwable error) {
        super(i2, i3);
        Intrinsics.checkNotNullParameter(error, "error");
        this.f14093a = error;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("error", this.f14093a.getMessage());
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topAnimationFailure";
    }
}
