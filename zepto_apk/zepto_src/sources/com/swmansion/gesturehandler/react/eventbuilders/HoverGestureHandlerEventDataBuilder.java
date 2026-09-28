package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.HoverGestureHandler;
import com.swmansion.gesturehandler.core.StylusData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class HoverGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<HoverGestureHandler> {

    /* renamed from: e, reason: collision with root package name */
    public final float f46870e;

    /* renamed from: f, reason: collision with root package name */
    public final float f46871f;

    /* renamed from: g, reason: collision with root package name */
    public final float f46872g;

    /* renamed from: h, reason: collision with root package name */
    public final float f46873h;

    /* renamed from: i, reason: collision with root package name */
    public final StylusData f46874i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HoverGestureHandlerEventDataBuilder(HoverGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46870e = handler.t;
        this.f46871f = handler.u;
        this.f46872g = handler.n();
        this.f46873h = handler.o();
        this.f46874i = handler.O;
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public final void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.a(eventData);
        eventData.putDouble("x", PixelUtil.a(this.f46870e));
        eventData.putDouble("y", PixelUtil.a(this.f46871f));
        eventData.putDouble("absoluteX", PixelUtil.a(this.f46872g));
        eventData.putDouble("absoluteY", PixelUtil.a(this.f46873h));
        StylusData stylusData = this.f46874i;
        if (stylusData.f46788e == -1.0d) {
            return;
        }
        eventData.putMap("stylusData", stylusData.a());
    }
}
