package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.LongPressGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class LongPressGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<LongPressGestureHandler> {

    /* renamed from: e, reason: collision with root package name */
    public final float f46875e;

    /* renamed from: f, reason: collision with root package name */
    public final float f46876f;

    /* renamed from: g, reason: collision with root package name */
    public final float f46877g;

    /* renamed from: h, reason: collision with root package name */
    public final float f46878h;

    /* renamed from: i, reason: collision with root package name */
    public final int f46879i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongPressGestureHandlerEventDataBuilder(LongPressGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46875e = handler.t;
        this.f46876f = handler.u;
        this.f46877g = handler.n();
        this.f46878h = handler.o();
        this.f46879i = (int) (handler.T - handler.S);
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public final void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.a(eventData);
        eventData.putDouble("x", PixelUtil.a(this.f46875e));
        eventData.putDouble("y", PixelUtil.a(this.f46876f));
        eventData.putDouble("absoluteX", PixelUtil.a(this.f46877g));
        eventData.putDouble("absoluteY", PixelUtil.a(this.f46878h));
        eventData.putInt("duration", this.f46879i);
    }
}
