package com.swmansion.gesturehandler.react.eventbuilders;

import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public abstract class GestureHandlerEventDataBuilder<T extends GestureHandler<T>> {

    /* renamed from: a, reason: collision with root package name */
    public final int f46866a;

    /* renamed from: b, reason: collision with root package name */
    public final int f46867b;

    /* renamed from: c, reason: collision with root package name */
    public final int f46868c;

    /* renamed from: d, reason: collision with root package name */
    public final int f46869d;

    public GestureHandlerEventDataBuilder(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46866a = handler.z;
        this.f46867b = handler.f46717d;
        this.f46868c = handler.f46719f;
        this.f46869d = handler.D;
    }

    public void a(WritableMap eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        eventData.putInt("numberOfPointers", this.f46866a);
        eventData.putInt("handlerTag", this.f46867b);
        eventData.putInt("state", this.f46868c);
        eventData.putInt("pointerType", this.f46869d);
    }
}
