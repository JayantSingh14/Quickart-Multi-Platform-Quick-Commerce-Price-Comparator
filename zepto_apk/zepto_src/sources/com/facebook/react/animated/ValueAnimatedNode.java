package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public class ValueAnimatedNode extends AnimatedNode {

    /* renamed from: e, reason: collision with root package name */
    public double f18673e;

    /* renamed from: f, reason: collision with root package name */
    public double f18674f;

    /* renamed from: g, reason: collision with root package name */
    public AnimatedNodeValueListener f18675g;

    public ValueAnimatedNode() {
        this(null);
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String d() {
        return "ValueAnimatedNode[" + this.f18524d + "]: value: " + this.f18673e + " offset: " + this.f18674f;
    }

    public Object f() {
        return null;
    }

    public final double g() {
        if (Double.isNaN(this.f18674f + this.f18673e)) {
            e();
        }
        return this.f18674f + this.f18673e;
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.f18673e = readableMap != null ? readableMap.getDouble(CLConstants.FIELD_PAY_INFO_VALUE) : Double.NaN;
        this.f18674f = readableMap != null ? readableMap.getDouble("offset") : 0.0d;
    }
}
