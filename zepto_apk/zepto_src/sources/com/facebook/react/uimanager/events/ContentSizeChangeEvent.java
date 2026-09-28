package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public final class ContentSizeChangeEvent extends Event<ContentSizeChangeEvent> {

    /* renamed from: a, reason: collision with root package name */
    public final int f19707a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19708b;

    public ContentSizeChangeEvent(int i2, int i3, int i4) {
        super(-1, i2);
        this.f19707a = i3;
        this.f19708b = i4;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble(Snapshot.WIDTH, PixelUtil.a(this.f19707a));
        writableMapCreateMap.putDouble(Snapshot.HEIGHT, PixelUtil.a(this.f19708b));
        return writableMapCreateMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public final String getEventName() {
        return "topContentSizeChange";
    }
}
