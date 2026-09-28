package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SubtractionAnimatedNode extends ValueAnimatedNode {

    /* renamed from: h, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18661h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f18662i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtractionAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        int[] iArr;
        super(null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18661h = nativeAnimatedNodesManager;
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
        this.f18662i = iArr;
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public final String d() {
        return "SubtractionAnimatedNode[" + this.f18524d + "]: input nodes: " + this.f18662i + " - super: " + super.d();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void e() {
        int[] iArr = this.f18662i;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            AnimatedNode animatedNodeH = this.f18661h.h(iArr[i2]);
            if (animatedNodeH == null || !(animatedNodeH instanceof ValueAnimatedNode)) {
                throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.subtract node");
            }
            double dG = ((ValueAnimatedNode) animatedNodeH).g();
            if (i2 == 0) {
                this.f18673e = dG;
            } else {
                this.f18673e -= dG;
            }
        }
    }
}
