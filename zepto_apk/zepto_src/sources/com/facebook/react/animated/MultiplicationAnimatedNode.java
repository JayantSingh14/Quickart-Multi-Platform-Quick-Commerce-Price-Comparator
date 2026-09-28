package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class MultiplicationAnimatedNode extends ValueAnimatedNode {

    /* renamed from: h, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18573h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f18574i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiplicationAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        int[] iArr;
        super(null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18573h = nativeAnimatedNodesManager;
        ReadableArray array = config.getArray("input");
        if (array == null) {
            iArr = new int[0];
        } else {
            int size = array.size();
            int[] iArr2 = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr2[i2] = array.getInt(i2);
            }
            iArr = iArr2;
        }
        this.f18574i = iArr;
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public final String d() {
        return "MultiplicationAnimatedNode[" + this.f18524d + "]: input nodes: " + this.f18574i + " - super: " + super.d();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void e() {
        this.f18673e = 1.0d;
        for (int i2 : this.f18574i) {
            AnimatedNode animatedNodeH = this.f18573h.h(i2);
            if (animatedNodeH == null || !(animatedNodeH instanceof ValueAnimatedNode)) {
                return;
            }
            this.f18673e *= ((ValueAnimatedNode) animatedNodeH).g();
        }
    }
}
