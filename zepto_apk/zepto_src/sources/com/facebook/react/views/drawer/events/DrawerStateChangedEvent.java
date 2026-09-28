package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DrawerStateChangedEvent extends Event<DrawerStateChangedEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final int f19937a;

    @Metadata
    public static final class Companion {
    }

    public DrawerStateChangedEvent(int i2, int i3, int i4) {
        super(i2, i3);
        this.f19937a = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        writableMapCreateMap.putInt("drawerState", this.f19937a);
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topDrawerStateChanged";
    }
}
