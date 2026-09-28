package com.google.android.material.transition;

import android.graphics.RectF;

/* loaded from: classes4.dex */
class FitModeEvaluators {

    /* renamed from: a, reason: collision with root package name */
    public static final AnonymousClass1 f41505a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public static final AnonymousClass2 f41506b = new AnonymousClass2();

    /* renamed from: com.google.android.material.transition.FitModeEvaluators$1, reason: invalid class name */
    public class AnonymousClass1 implements FitModeEvaluator {
        @Override // com.google.android.material.transition.FitModeEvaluator
        public final FitModeResult a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float fD = TransitionUtils.d(f5, f7, f3, f4, f2, true);
            float f9 = fD / f5;
            float f10 = fD / f7;
            return new FitModeResult(f9, f10, fD, f6 * f9, fD, f8 * f10);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public final boolean b(FitModeResult fitModeResult) {
            return fitModeResult.f41510d > fitModeResult.f41512f;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public final void c(RectF rectF, float f2, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.f41512f - fitModeResult.f41510d) * f2;
        }
    }

    /* renamed from: com.google.android.material.transition.FitModeEvaluators$2, reason: invalid class name */
    public class AnonymousClass2 implements FitModeEvaluator {
        @Override // com.google.android.material.transition.FitModeEvaluator
        public final FitModeResult a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float fD = TransitionUtils.d(f6, f8, f3, f4, f2, true);
            float f9 = fD / f6;
            float f10 = fD / f8;
            return new FitModeResult(f9, f10, f5 * f9, fD, f7 * f10, fD);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public final boolean b(FitModeResult fitModeResult) {
            return fitModeResult.f41509c > fitModeResult.f41511e;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public final void c(RectF rectF, float f2, FitModeResult fitModeResult) {
            float fAbs = (Math.abs(fitModeResult.f41511e - fitModeResult.f41509c) / 2.0f) * f2;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }
}
