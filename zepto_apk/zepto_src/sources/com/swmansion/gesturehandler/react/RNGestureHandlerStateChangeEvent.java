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
public final class RNGestureHandlerStateChangeEvent extends Event<RNGestureHandlerStateChangeEvent> {

    /* renamed from: d, reason: collision with root package name */
    public static final Pools.SynchronizedPool f46853d = new Pools.SynchronizedPool(7);

    /* renamed from: a, reason: collision with root package name */
    public GestureHandlerEventDataBuilder f46854a;

    /* renamed from: b, reason: collision with root package name */
    public int f46855b;

    /* renamed from: c, reason: collision with root package name */
    public int f46856c;

    @Metadata
    public static final class Companion {
        public static WritableMap a(GestureHandlerEventDataBuilder dataBuilder, int i2, int i3) {
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.c(writableMapCreateMap);
            dataBuilder.a(writableMapCreateMap);
            writableMapCreateMap.putInt("state", i2);
            writableMapCreateMap.putInt("oldState", i3);
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            return writableMapCreateMap;
        }

        public static RNGestureHandlerStateChangeEvent b(GestureHandler handler, int i2, int i3, GestureHandlerEventDataBuilder dataBuilder) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(dataBuilder, "dataBuilder");
            RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent = (RNGestureHandlerStateChangeEvent) RNGestureHandlerStateChangeEvent.f46853d.b();
            if (rNGestureHandlerStateChangeEvent == null) {
                rNGestureHandlerStateChangeEvent = new RNGestureHandlerStateChangeEvent();
            }
            RNGestureHandlerStateChangeEvent.a(rNGestureHandlerStateChangeEvent, handler, i2, i3, dataBuilder);
            return rNGestureHandlerStateChangeEvent;
        }
    }

    public static final void a(RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent, GestureHandler gestureHandler, int i2, int i3, GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder) {
        View view = gestureHandler.f46718e;
        Intrinsics.c(view);
        super.init(UIManagerHelper.e(view), view.getId());
        rNGestureHandlerStateChangeEvent.f46854a = gestureHandlerEventDataBuilder;
        rNGestureHandlerStateChangeEvent.f46855b = i2;
        rNGestureHandlerStateChangeEvent.f46856c = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return (short) 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        GestureHandlerEventDataBuilder gestureHandlerEventDataBuilder = this.f46854a;
        Intrinsics.c(gestureHandlerEventDataBuilder);
        return Companion.a(gestureHandlerEventDataBuilder, this.f46855b, this.f46856c);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "onGestureHandlerStateChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void onDispose() {
        this.f46854a = null;
        this.f46855b = 0;
        this.f46856c = 0;
        f46853d.a(this);
    }
}
