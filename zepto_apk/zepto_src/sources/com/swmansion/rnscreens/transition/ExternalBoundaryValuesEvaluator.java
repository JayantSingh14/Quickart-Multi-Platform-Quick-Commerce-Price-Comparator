package com.swmansion.rnscreens.transition;

import android.animation.FloatEvaluator;
import com.brentvatne.common.react.r;
import com.brentvatne.react.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ExternalBoundaryValuesEvaluator extends FloatEvaluator {

    /* renamed from: a, reason: collision with root package name */
    public final c f47142a;

    /* renamed from: b, reason: collision with root package name */
    public final r f47143b;

    /* renamed from: c, reason: collision with root package name */
    public Number f47144c;

    /* renamed from: d, reason: collision with root package name */
    public Number f47145d;

    public ExternalBoundaryValuesEvaluator(c startValueProvider, r endValueProvider) {
        Intrinsics.checkNotNullParameter(startValueProvider, "startValueProvider");
        Intrinsics.checkNotNullParameter(endValueProvider, "endValueProvider");
        this.f47142a = startValueProvider;
        this.f47143b = endValueProvider;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.animation.TypeEvaluator
    public final Float evaluate(float f2, Number number, Number number2) throws Exception {
        if (this.f47144c == null) {
            this.f47144c = (Number) this.f47142a.invoke(number);
        }
        Number number3 = this.f47144c;
        if (this.f47145d == null) {
            this.f47143b.invoke(number2);
            this.f47145d = Float.valueOf(0.0f);
        }
        Number number4 = this.f47145d;
        if (number3 == null || number4 == null) {
            return null;
        }
        return super.evaluate(f2, number3, number4);
    }
}
