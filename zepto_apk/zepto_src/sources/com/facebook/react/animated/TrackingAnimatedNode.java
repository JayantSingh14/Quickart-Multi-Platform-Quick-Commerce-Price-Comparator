package com.facebook.react.animated;

import android.support.v4.media.b;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class TrackingAnimatedNode extends AnimatedNode {

    /* renamed from: e, reason: collision with root package name */
    public final NativeAnimatedNodesManager f18663e;

    /* renamed from: f, reason: collision with root package name */
    public final JavaOnlyMap f18664f;

    /* renamed from: g, reason: collision with root package name */
    public final int f18665g;

    /* renamed from: h, reason: collision with root package name */
    public final int f18666h;

    /* renamed from: i, reason: collision with root package name */
    public final int f18667i;

    public TrackingAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.f18663e = nativeAnimatedNodesManager;
        this.f18664f = JavaOnlyMap.Companion.deepClone(config.getMap("animationConfig"));
        this.f18665g = config.getInt("animationId");
        this.f18666h = config.getInt("toValue");
        this.f18667i = config.getInt(CLConstants.FIELD_PAY_INFO_VALUE);
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final String d() {
        StringBuilder sbU = b.u(this.f18524d, "TrackingAnimatedNode[", "]: animationID: ");
        sbU.append(this.f18665g);
        sbU.append(" toValueNode: ");
        sbU.append(this.f18666h);
        sbU.append(" valueNode: ");
        sbU.append(this.f18667i);
        sbU.append(" animationConfig: ");
        sbU.append(this.f18664f);
        return sbU.toString();
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void e() {
        int i2 = this.f18666h;
        NativeAnimatedNodesManager nativeAnimatedNodesManager = this.f18663e;
        AnimatedNode animatedNodeH = nativeAnimatedNodesManager.h(i2);
        ValueAnimatedNode valueAnimatedNode = animatedNodeH instanceof ValueAnimatedNode ? (ValueAnimatedNode) animatedNodeH : null;
        JavaOnlyMap javaOnlyMap = this.f18664f;
        if (valueAnimatedNode != null) {
            javaOnlyMap.putDouble("toValue", valueAnimatedNode.g());
        } else {
            javaOnlyMap.putNull("toValue");
        }
        nativeAnimatedNodesManager.o(this.f18665g, javaOnlyMap, null, this.f18667i);
    }
}
