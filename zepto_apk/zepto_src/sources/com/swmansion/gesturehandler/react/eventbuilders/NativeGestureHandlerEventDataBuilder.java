package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class NativeGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<NativeViewGestureHandler> {

    /* renamed from: e, reason: collision with root package name */
    public final boolean f46880e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeGestureHandlerEventDataBuilder(NativeViewGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46880e = handler.f46722i;
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public final void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.a(eventData);
        eventData.putBoolean("pointerInside", this.f46880e);
    }
}
