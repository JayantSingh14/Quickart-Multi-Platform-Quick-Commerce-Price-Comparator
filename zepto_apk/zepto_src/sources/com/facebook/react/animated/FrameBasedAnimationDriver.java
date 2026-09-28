package com.facebook.react.animated;

import android.support.v4.media.b;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FrameBasedAnimationDriver extends AnimationDriver {

    /* renamed from: e, reason: collision with root package name */
    public long f18551e;

    /* renamed from: f, reason: collision with root package name */
    public double[] f18552f;

    /* renamed from: g, reason: collision with root package name */
    public double f18553g;

    /* renamed from: h, reason: collision with root package name */
    public double f18554h;

    /* renamed from: i, reason: collision with root package name */
    public int f18555i;

    /* renamed from: j, reason: collision with root package name */
    public int f18556j;

    /* renamed from: k, reason: collision with root package name */
    public int f18557k;

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public final void a(ReadableMap config) {
        int size;
        Intrinsics.checkNotNullParameter(config, "config");
        ReadableArray array = config.getArray("frames");
        if (array != null && this.f18552f.length != (size = array.size())) {
            double[] dArr = new double[size];
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = array.getDouble(i2);
            }
            this.f18552f = dArr;
        }
        this.f18553g = (config.hasKey("toValue") && config.getType("toValue") == ReadableType.Number) ? config.getDouble("toValue") : 0.0d;
        int i3 = (config.hasKey("iterations") && config.getType("iterations") == ReadableType.Number) ? config.getInt("iterations") : 1;
        this.f18555i = i3;
        this.f18556j = 1;
        this.f18525a = i3 == 0;
        this.f18551e = -1L;
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public final void b(long j2) {
        double d2;
        ValueAnimatedNode valueAnimatedNode = this.f18526b;
        if (valueAnimatedNode == null) {
            throw new IllegalArgumentException("Animated value should not be null");
        }
        if (this.f18551e < 0) {
            this.f18551e = j2;
            if (this.f18556j == 1) {
                this.f18554h = valueAnimatedNode.f18673e;
            }
        }
        int iRound = (int) Math.round(((j2 - this.f18551e) / 1000000) / 16.666666666666668d);
        if (iRound < 0) {
            long j3 = this.f18551e;
            StringBuilder sbV = b.v(j2, "Calculated frame index should never be lower than 0. Called with frameTimeNanos ", " and mStartFrameTimeNanos ");
            sbV.append(j3);
            String string = sbV.toString();
            if (this.f18557k < 100) {
                FLog.q("ReactNative", string);
                this.f18557k++;
                return;
            }
            return;
        }
        if (this.f18525a) {
            return;
        }
        double[] dArr = this.f18552f;
        if (iRound >= dArr.length - 1) {
            int i2 = this.f18555i;
            if (i2 == -1 || this.f18556j < i2) {
                double d3 = this.f18554h;
                d2 = ((this.f18553g - d3) * dArr[dArr.length - 1]) + d3;
                this.f18551e = -1L;
                this.f18556j++;
            } else {
                d2 = this.f18553g;
                this.f18525a = true;
            }
        } else {
            double d4 = this.f18554h;
            d2 = ((this.f18553g - d4) * dArr[iRound]) + d4;
        }
        valueAnimatedNode.f18673e = d2;
    }
}
