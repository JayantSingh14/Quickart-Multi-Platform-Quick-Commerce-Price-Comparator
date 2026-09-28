package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.PanGestureHandler;
import com.swmansion.gesturehandler.core.StylusData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class PanGestureHandlerEventDataBuilder extends GestureHandlerEventDataBuilder<PanGestureHandler> {

    /* renamed from: e, reason: collision with root package name */
    public final float f46881e;

    /* renamed from: f, reason: collision with root package name */
    public final float f46882f;

    /* renamed from: g, reason: collision with root package name */
    public final float f46883g;

    /* renamed from: h, reason: collision with root package name */
    public final float f46884h;

    /* renamed from: i, reason: collision with root package name */
    public final float f46885i;

    /* renamed from: j, reason: collision with root package name */
    public final float f46886j;

    /* renamed from: k, reason: collision with root package name */
    public final float f46887k;

    /* renamed from: l, reason: collision with root package name */
    public final float f46888l;

    /* renamed from: m, reason: collision with root package name */
    public final StylusData f46889m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanGestureHandlerEventDataBuilder(PanGestureHandler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46881e = handler.t;
        this.f46882f = handler.u;
        this.f46883g = handler.n();
        this.f46884h = handler.o();
        this.f46885i = (handler.h0 - handler.d0) + handler.f0;
        this.f46886j = (handler.i0 - handler.e0) + handler.g0;
        this.f46887k = handler.M;
        this.f46888l = handler.N;
        this.f46889m = handler.o0;
    }

    @Override // com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder
    public final void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        super.a(eventData);
        eventData.putDouble("x", PixelUtil.a(this.f46881e));
        eventData.putDouble("y", PixelUtil.a(this.f46882f));
        eventData.putDouble("absoluteX", PixelUtil.a(this.f46883g));
        eventData.putDouble("absoluteY", PixelUtil.a(this.f46884h));
        eventData.putDouble("translationX", PixelUtil.a(this.f46885i));
        eventData.putDouble("translationY", PixelUtil.a(this.f46886j));
        eventData.putDouble("velocityX", PixelUtil.a(this.f46887k));
        eventData.putDouble("velocityY", PixelUtil.a(this.f46888l));
        StylusData stylusData = this.f46889m;
        if (stylusData.f46788e == -1.0d) {
            return;
        }
        eventData.putMap("stylusData", stylusData.a());
    }
}
