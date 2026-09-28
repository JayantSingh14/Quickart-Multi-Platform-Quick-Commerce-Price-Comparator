package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.RotationGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class RotationGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<RotationGestureHandler> {

    /* renamed from: e, reason: collision with root package name */
    public final double f46894e;

    /* renamed from: f, reason: collision with root package name */
    public final float f46895f;

    /* renamed from: g, reason: collision with root package name */
    public final float f46896g;

    /* renamed from: h, reason: collision with root package name */
    public final double f46897h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotationGestureHandlerEventDataBuilder(RotationGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46894e = handler.N;
        this.f46895f = handler.P;
        this.f46896g = handler.Q;
        this.f46897h = handler.O;
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public final void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.a(eventData);
        eventData.putDouble("rotation", this.f46894e);
        eventData.putDouble("anchorX", PixelUtil.a(this.f46895f));
        eventData.putDouble("anchorY", PixelUtil.a(this.f46896g));
        eventData.putDouble("velocity", this.f46897h);
    }
}
