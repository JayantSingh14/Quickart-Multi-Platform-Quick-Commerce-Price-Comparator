package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SimpleSpringInterpolator implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float f19833a;

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public SimpleSpringInterpolator() {
        this(0.5f);
    }

    public static final float a(ReadableMap params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.getType("springDamping") == ReadableType.Number) {
            return (float) params.getDouble("springDamping");
        }
        return 0.5f;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        return (float) ((Math.sin((((f2 - (r5 / 4)) * 3.141592653589793d) * 2) / this.f19833a) * Math.pow(2.0d, (-10) * f2)) + 1);
    }

    public SimpleSpringInterpolator(float f2) {
        this.f19833a = f2;
    }
}
