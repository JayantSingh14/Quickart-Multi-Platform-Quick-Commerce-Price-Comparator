package com.zeptoconsumerapp.ZeptoImage;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ImageEvent extends Event<ImageEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final String f47565a;

    /* renamed from: b, reason: collision with root package name */
    public final WritableMap f47566b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageEvent(int i2, int i3, String eventName, WritableMap writableMap) {
        super(i2, i3);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.f47565a = eventName;
        this.f47566b = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        return this.f47566b;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return this.f47565a;
    }
}
