package com.facebook.react.animated;

import android.support.v4.media.b;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DiffClampAnimatedNode extends ValueAnimatedNode {

    /* renamed from: h, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18544h;

    /* renamed from: i, reason: collision with root package name */
    public final int f18545i;

    /* renamed from: j, reason: collision with root package name */
    public final double f18546j;

    /* renamed from: k, reason: collision with root package name */
    public final double f18547k;

    /* renamed from: l, reason: collision with root package name */
    public double f18548l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffClampAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        super(null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18544h = nativeAnimatedNodesManager;
        this.f18545i = config.getInt("input");
        this.f18546j = config.getDouble("min");
        this.f18547k = config.getDouble("max");
        this.f18673e = this.f18548l;
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public final String d() {
        int i2 = this.f18524d;
        double d2 = this.f18548l;
        String strD = super.d();
        StringBuilder sbU = b.u(i2, "DiffClampAnimatedNode[", "]: InputNodeTag: ");
        sbU.append(this.f18545i);
        sbU.append(" min: ");
        sbU.append(this.f18546j);
        sbU.append(" max: ");
        sbU.append(this.f18547k);
        sbU.append(" lastValue: ");
        sbU.append(d2);
        sbU.append(" super: ");
        sbU.append(strD);
        return sbU.toString();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void e() {
        NativeAnimatedNodesManager nativeAnimatedNodesManager = this.f18544h;
        int i2 = this.f18545i;
        AnimatedNode animatedNodeH = nativeAnimatedNodesManager.h(i2);
        Double dValueOf = null;
        if (((animatedNodeH == null || !(animatedNodeH instanceof ValueAnimatedNode)) ? null : Double.valueOf(((ValueAnimatedNode) animatedNodeH).g())) != null) {
            AnimatedNode animatedNodeH2 = nativeAnimatedNodesManager.h(i2);
            if (animatedNodeH2 != null && (animatedNodeH2 instanceof ValueAnimatedNode)) {
                dValueOf = Double.valueOf(((ValueAnimatedNode) animatedNodeH2).g());
            }
            Intrinsics.c(dValueOf);
            double dDoubleValue = dValueOf.doubleValue();
            double d2 = dDoubleValue - this.f18548l;
            this.f18548l = dDoubleValue;
            this.f18673e = Math.min(Math.max(this.f18673e + d2, this.f18546j), this.f18547k);
        }
    }
}
