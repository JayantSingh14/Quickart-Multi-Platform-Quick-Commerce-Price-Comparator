package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.TapGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class TapGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<TapGestureHandler> {

    /* renamed from: e, reason: collision with root package name */
    public final float f46898e;

    /* renamed from: f, reason: collision with root package name */
    public final float f46899f;

    /* renamed from: g, reason: collision with root package name */
    public final float f46900g;

    /* renamed from: h, reason: collision with root package name */
    public final float f46901h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureHandlerEventDataBuilder(TapGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46898e = handler.t;
        this.f46899f = handler.u;
        this.f46900g = handler.n();
        this.f46901h = handler.o();
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public final void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.a(eventData);
        eventData.putDouble("x", PixelUtil.a(this.f46898e));
        eventData.putDouble("y", PixelUtil.a(this.f46899f));
        eventData.putDouble("absoluteX", PixelUtil.a(this.f46900g));
        eventData.putDouble("absoluteY", PixelUtil.a(this.f46901h));
    }
}
