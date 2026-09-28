package com.facebook.react.animated;

import androidx.fragment.app.e;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.uimanager.events.TouchEvent;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class EventAnimationDriver implements RCTModernEventEmitter {

    @JvmField
    @NotNull
    public String eventName;

    @NotNull
    private final List<String> eventPath;

    @JvmField
    @NotNull
    public ValueAnimatedNode valueNode;

    @JvmField
    public int viewTag;

    public EventAnimationDriver(@NotNull String eventName, int i2, @NotNull List<String> eventPath, @NotNull ValueAnimatedNode valueNode) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventPath, "eventPath");
        Intrinsics.checkNotNullParameter(valueNode, "valueNode");
        this.eventName = eventName;
        this.viewTag = i2;
        this.eventPath = eventPath;
        this.valueNode = valueNode;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated
    public void receiveEvent(int i2, @NotNull String eventName, @Nullable WritableMap writableMap) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(-1, i2, eventName, writableMap);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    @Deprecated
    public void receiveTouches(@NotNull TouchEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i2, int i3, @NotNull String eventName, @Nullable WritableMap writableMap) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(i2, i3, eventName, false, 0, writableMap, 2);
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    @Deprecated
    public void receiveTouches(@NotNull String eventName, @NotNull WritableArray touches, @NotNull WritableArray changedIndices) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int i2, int i3, @NotNull String eventName, boolean z, int i4, @Nullable WritableMap writableMap, int i5) throws NumberFormatException {
        ReadableMap map;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (writableMap == null) {
            return;
        }
        int size = this.eventPath.size() - 1;
        ReadableArray array = null;
        for (int i6 = 0; i6 < size; i6++) {
            if (writableMap != null) {
                String str = this.eventPath.get(i6);
                ReadableType type = writableMap.getType(str);
                if (type == ReadableType.Map) {
                    map = writableMap.getMap(str);
                    writableMap = map;
                    array = null;
                } else if (type == ReadableType.Array) {
                    array = writableMap.getArray(str);
                    writableMap = null;
                }
            } else {
                int i7 = Integer.parseInt(this.eventPath.get(i6));
                ReadableType type2 = array != null ? array.getType(i7) : null;
                if (type2 == ReadableType.Map) {
                    map = array != null ? array.getMap(i7) : null;
                    writableMap = map;
                    array = null;
                } else if (type2 == ReadableType.Array) {
                    array = array != null ? array.getArray(i7) : null;
                    writableMap = null;
                }
            }
        }
        String str2 = (String) e.k(1, this.eventPath);
        if (writableMap != null) {
            this.valueNode.f18673e = writableMap.getDouble(str2);
            return;
        }
        this.valueNode.f18673e = array != null ? array.getDouble(Integer.parseInt(str2)) : 0.0d;
    }
}
