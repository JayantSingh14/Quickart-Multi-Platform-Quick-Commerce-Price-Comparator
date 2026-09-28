package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AdditionAnimatedNode extends ValueAnimatedNode {

    /* renamed from: h, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18519h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f18520i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdditionAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        int[] iArr;
        super(null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18519h = nativeAnimatedNodesManager;
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
        this.f18520i = iArr;
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public final String d() {
        return "AdditionAnimatedNode[" + this.f18524d + "]: input nodes: " + ArraysKt.B(63, this.f18520i) + " - super: " + super.d();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void e() {
        this.f18673e = 0.0d;
        double dG = 0.0d;
        for (int i2 : this.f18520i) {
            AnimatedNode animatedNodeH = this.f18519h.h(i2);
            dG = animatedNodeH instanceof ValueAnimatedNode ? ((ValueAnimatedNode) animatedNodeH).g() + dG : dG + 0.0d;
        }
        this.f18673e = 0.0d + dG;
    }
}
