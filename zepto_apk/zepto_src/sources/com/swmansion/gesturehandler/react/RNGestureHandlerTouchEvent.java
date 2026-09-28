package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class RNGestureHandlerTouchEvent extends Event<RNGestureHandlerTouchEvent> {

    /* renamed from: c, reason: collision with root package name */
    public static final Pools.SynchronizedPool f46857c = new Pools.SynchronizedPool(7);

    /* renamed from: a, reason: collision with root package name */
    public WritableMap f46858a;

    /* renamed from: b, reason: collision with root package name */
    public short f46859b;

    @Metadata
    public static final class Companion {
        public static WritableMap a(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("handlerTag", handler.f46717d);
            writableMapCreateMap.putInt("state", handler.f46719f);
            writableMapCreateMap.putInt("numberOfTouches", handler.o);
            writableMapCreateMap.putInt("eventType", handler.n);
            writableMapCreateMap.putInt("pointerType", handler.D);
            WritableArray writableArray = handler.f46725l;
            handler.f46725l = null;
            if (writableArray != null) {
                writableMapCreateMap.putArray("changedTouches", writableArray);
            }
            WritableArray writableArray2 = handler.f46726m;
            handler.f46726m = null;
            if (writableArray2 != null) {
                writableMapCreateMap.putArray("allTouches", writableArray2);
            }
            if (handler.H && handler.f46719f == 4) {
                writableMapCreateMap.putInt("state", 2);
            }
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            return writableMapCreateMap;
        }

        public static RNGestureHandlerTouchEvent b(GestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent = (RNGestureHandlerTouchEvent) RNGestureHandlerTouchEvent.f46857c.b();
            if (rNGestureHandlerTouchEvent == null) {
                rNGestureHandlerTouchEvent = new RNGestureHandlerTouchEvent();
            }
            RNGestureHandlerTouchEvent.a(rNGestureHandlerTouchEvent, handler);
            return rNGestureHandlerTouchEvent;
        }
    }

    public static final void a(RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent, GestureHandler gestureHandler) {
        View view = gestureHandler.f46718e;
        Intrinsics.c(view);
        super.init(UIManagerHelper.e(view), view.getId());
        rNGestureHandlerTouchEvent.f46858a = Companion.a(gestureHandler);
        rNGestureHandlerTouchEvent.f46859b = gestureHandler.s;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final boolean canCoalesce() {
        return true;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final short getCoalescingKey() {
        return this.f46859b;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        return this.f46858a;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "onGestureHandlerEvent";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void onDispose() {
        this.f46858a = null;
        f46857c.a(this);
    }
}
