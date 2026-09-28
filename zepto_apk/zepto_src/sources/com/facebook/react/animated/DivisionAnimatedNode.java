package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DivisionAnimatedNode extends ValueAnimatedNode {

    /* renamed from: h, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18549h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f18550i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivisionAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        int[] iArr;
        super(null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18549h = nativeAnimatedNodesManager;
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
        this.f18550i = iArr;
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public final String d() {
        return "DivisionAnimatedNode[" + this.f18524d + "]: input nodes: " + this.f18550i + " - super: " + super.d();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void e() {
        int[] iArr = this.f18550i;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            AnimatedNode animatedNodeH = this.f18549h.h(iArr[i2]);
            if (animatedNodeH == null || !(animatedNodeH instanceof ValueAnimatedNode)) {
                return;
            }
            double d2 = ((ValueAnimatedNode) animatedNodeH).f18673e;
            if (i3 == 0) {
                this.f18673e = d2;
            } else if (d2 == 0.0d) {
                return;
            } else {
                this.f18673e /= d2;
            }
            i2++;
            i3 = i4;
        }
    }
}
