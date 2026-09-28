package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DecayAnimation extends AnimationDriver {

    /* renamed from: e, reason: collision with root package name */
    public double f18537e;

    /* renamed from: f, reason: collision with root package name */
    public double f18538f;

    /* renamed from: g, reason: collision with root package name */
    public long f18539g;

    /* renamed from: h, reason: collision with root package name */
    public double f18540h;

    /* renamed from: i, reason: collision with root package name */
    public double f18541i;

    /* renamed from: j, reason: collision with root package name */
    public int f18542j;

    /* renamed from: k, reason: collision with root package name */
    public int f18543k;

    public DecayAnimation(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f18539g = -1L;
        this.f18542j = 1;
        this.f18543k = 1;
        a(config);
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public final void a(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f18537e = config.getDouble("velocity");
        this.f18538f = config.getDouble("deceleration");
        this.f18539g = -1L;
        this.f18540h = 0.0d;
        this.f18541i = 0.0d;
        int i2 = config.hasKey("iterations") ? config.getInt("iterations") : 1;
        this.f18542j = i2;
        this.f18543k = 1;
        this.f18525a = i2 == 0;
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public final void b(long j2) {
        ValueAnimatedNode valueAnimatedNode = this.f18526b;
        if (valueAnimatedNode == null) {
            throw new IllegalArgumentException("Animated value should not be null");
        }
        long j3 = j2 / 1000000;
        if (this.f18539g == -1) {
            this.f18539g = j3 - 16;
            double d2 = this.f18540h;
            if (d2 == this.f18541i) {
                this.f18540h = valueAnimatedNode.f18673e;
            } else {
                valueAnimatedNode.f18673e = d2;
            }
            this.f18541i = valueAnimatedNode.f18673e;
        }
        double d3 = this.f18540h;
        double d4 = this.f18537e;
        double d5 = 1;
        double d6 = this.f18538f;
        double dExp = ((d5 - Math.exp((-(d5 - d6)) * (j3 - this.f18539g))) * (d4 / (d5 - d6))) + d3;
        if (Math.abs(this.f18541i - dExp) < 0.1d) {
            int i2 = this.f18542j;
            if (i2 != -1 && this.f18543k >= i2) {
                this.f18525a = true;
                return;
            } else {
                this.f18539g = -1L;
                this.f18543k++;
            }
        }
        this.f18541i = dExp;
        valueAnimatedNode.f18673e = dExp;
    }
}
