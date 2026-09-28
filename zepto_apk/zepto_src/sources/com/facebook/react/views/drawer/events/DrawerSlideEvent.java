package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DrawerSlideEvent extends Event<DrawerSlideEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final float f19936a;

    @Metadata
    public static final class Companion {
    }

    public DrawerSlideEvent(float f2, int i2, int i3) {
        super(i2, i3);
        this.f19936a = f2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        writableMapCreateMap.putDouble("offset", this.f19936a);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topDrawerSlide";
    }
}
