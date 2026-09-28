package com.facebook.react.internal.interop;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class InteropEvent extends Event<InteropEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final String f18996a;

    /* renamed from: b, reason: collision with root package name */
    public final WritableMap f18997b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteropEvent(int i2, int i3, String eventName, WritableMap writableMap) {
        super(i2, i3);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.f18996a = eventName;
        this.f18997b = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        return this.f18997b;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return this.f18996a;
    }
}
