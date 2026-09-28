package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.FlingGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class FlingGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<FlingGestureHandler> {

    /* renamed from: e, reason: collision with root package name */
    public final float f46862e;

    /* renamed from: f, reason: collision with root package name */
    public final float f46863f;

    /* renamed from: g, reason: collision with root package name */
    public final float f46864g;

    /* renamed from: h, reason: collision with root package name */
    public final float f46865h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlingGestureHandlerEventDataBuilder(FlingGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46862e = handler.t;
        this.f46863f = handler.u;
        this.f46864g = handler.n();
        this.f46865h = handler.o();
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public final void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.a(eventData);
        eventData.putDouble("x", PixelUtil.a(this.f46862e));
        eventData.putDouble("y", PixelUtil.a(this.f46863f));
        eventData.putDouble("absoluteX", PixelUtil.a(this.f46864g));
        eventData.putDouble("absoluteY", PixelUtil.a(this.f46865h));
    }
}
