package com.facebook.react.animated;

import android.support.v4.media.b;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ModulusAnimatedNode extends ValueAnimatedNode {

    /* renamed from: h, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18570h;

    /* renamed from: i, reason: collision with root package name */
    public final int f18571i;

    /* renamed from: j, reason: collision with root package name */
    public final double f18572j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModulusAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        super(null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18570h = nativeAnimatedNodesManager;
        this.f18571i = config.getInt("input");
        this.f18572j = config.getDouble("modulus");
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public final String d() {
        int i2 = this.f18524d;
        String strD = super.d();
        StringBuilder sbU = b.u(i2, "NativeAnimatedNodesManager[", "] inputNode: ");
        sbU.append(this.f18571i);
        sbU.append(" modulus: ");
        sbU.append(this.f18572j);
        sbU.append(" super: ");
        sbU.append(strD);
        return sbU.toString();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void e() {
        AnimatedNode animatedNodeH = this.f18570h.h(this.f18571i);
        if (animatedNodeH instanceof ValueAnimatedNode) {
            double dG = ((ValueAnimatedNode) animatedNodeH).g();
            double d2 = this.f18572j;
            this.f18673e = ((dG % d2) + d2) % d2;
        }
    }
}
