package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class RNGestureHandlerEvent extends Event<RNGestureHandlerEvent> {

    /* renamed from: d, reason: collision with root package name */
    public static final Pools.SynchronizedPool f46816d = new Pools.SynchronizedPool(7);

    /* renamed from: a, reason: collision with root package name */
    public GestureHandlerEventDataBuilder f46817a;

    /* renamed from: b, reason: collision with root package name */
    public short f46818b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f46819c;

    @Metadata
    public static final class Companion {
        public static WritableMap a(GestureHandlerEventDataBuilder dataBuilder) {
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.c(writableMapCreateMap);
            dataBuilder.a(writableMapCreateMap);
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            return writableMapCreateMap;
        }

        public static RNGestureHandlerEvent b(GestureHandler handler, GestureHandlerEventDataBuilder dataBuilder, boolean z) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            RNGestureHandlerEvent rNGestureHandlerEvent = (RNGestureHandlerEvent) RNGestureHandlerEvent.f46816d.b();
            if (rNGestureHandlerEvent == null) {
                rNGestureHandlerEvent = new RNGestureHandlerEvent();
            }
            RNGestureHandlerEvent.a(rNGestureHandlerEvent, handler, dataBuilder, z);
            return rNGestureHandlerEvent;
        }
    }

    public static final void a(RNGestureHandlerEvent rNGestureHandlerEvent, GestureHandler gestureHandler, GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder, boolean z) {
        View view = gestureHandler.f46718e;
        Intrinsics.c(view);
        super.init(UIManagerHelper.e(view), view.getId());
        rNGestureHandlerEvent.f46817a = gestureHandlerEventDataBuilder;
        rNGestureHandlerEvent.f46819c = z;
        rNGestureHandlerEvent.f46818b = gestureHandler.s;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        return true;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return this.f46818b;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder = this.f46817a;
        Intrinsics.c(gestureHandlerEventDataBuilder);
        return Companion.a(gestureHandlerEventDataBuilder);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return this.f46819c ? "topGestureHandlerEvent" : "onGestureHandlerEvent";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void onDispose() {
        this.f46817a = null;
        f46816d.a(this);
    }
}
