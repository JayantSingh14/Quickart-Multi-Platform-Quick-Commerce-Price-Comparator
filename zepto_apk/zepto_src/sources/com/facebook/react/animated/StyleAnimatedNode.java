package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class StyleAnimatedNode extends AnimatedNode {

    /* renamed from: e, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18659e;

    /* renamed from: f, reason: collision with root package name */
    public final MapBuilder f18660f;

    public StyleAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18659e = nativeAnimatedNodesManager;
        ReadableMap map = config.getMap("style");
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map != null ? map.keySetIterator() : null;
        MapBuilder builder = new MapBuilder();
        while (readableMapKeySetIteratorKeySetIterator != null && readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            builder.put(strNextKey, Integer.valueOf(map.getInt(strNextKey)));
        }
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f18660f = builder.b();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final String d() {
        return "StyleAnimatedNode[" + this.f18524d + "] mPropMapping: " + this.f18660f;
    }
}
