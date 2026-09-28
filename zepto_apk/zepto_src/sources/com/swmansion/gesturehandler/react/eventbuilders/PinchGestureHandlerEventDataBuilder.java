package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.PinchGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class PinchGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<PinchGestureHandler> {

    /* renamed from: e, reason: collision with root package name */
    public final double f46890e;

    /* renamed from: f, reason: collision with root package name */
    public final float f46891f;

    /* renamed from: g, reason: collision with root package name */
    public final float f46892g;

    /* renamed from: h, reason: collision with root package name */
    public final double f46893h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinchGestureHandlerEventDataBuilder(PinchGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46890e = handler.M;
        this.f46891f = handler.O;
        this.f46892g = handler.P;
        this.f46893h = handler.N;
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public final void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.a(eventData);
        eventData.putDouble("scale", this.f46890e);
        eventData.putDouble("focalX", PixelUtil.a(this.f46891f));
        eventData.putDouble("focalY", PixelUtil.a(this.f46892g));
        eventData.putDouble("velocity", this.f46893h);
    }
}
