package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class InsetsChangeEvent extends Event<InsetsChangeEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final EdgeInsets f47158a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f47159b;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsetsChangeEvent(int i2, EdgeInsets mInsets, Rect mFrame) {
        super(i2);
        Intrinsics.checkNotNullParameter(mInsets, "mInsets");
        Intrinsics.checkNotNullParameter(mFrame, "mFrame");
        this.f47158a = mInsets;
        this.f47159b = mFrame;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putMap("insets", SerializationUtilsKt.a(this.f47158a));
        Rect rect = this.f47159b;
        Intrinsics.checkNotNullParameter(rect, "rect");
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("x", PixelUtil.a(rect.f47160a));
        writableMapCreateMap2.putDouble("y", PixelUtil.a(rect.f47161b));
        writableMapCreateMap2.putDouble(Snapshot.WIDTH, PixelUtil.a(rect.f47162c));
        writableMapCreateMap2.putDouble(Snapshot.HEIGHT, PixelUtil.a(rect.f47163d));
        writableMapCreateMap.putMap("frame", writableMapCreateMap2);
        rctEventEmitter.receiveEvent(getViewTag(), "topInsetsChange", writableMapCreateMap);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topInsetsChange";
    }
}
