package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes4.dex */
class FadeModeEvaluators {

    /* renamed from: a, reason: collision with root package name */
    public static final AnonymousClass1 f41557a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public static final AnonymousClass2 f41558b = new AnonymousClass2();

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$1, reason: invalid class name */
    public class AnonymousClass1 implements FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public final FadeModeResult a(float f2, float f3, float f4) {
            return new FadeModeResult(255, TransitionUtils.e(f3, f4, f2, 0, 255), true);
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$2, reason: invalid class name */
    public class AnonymousClass2 implements FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public final FadeModeResult a(float f2, float f3, float f4) {
            return new FadeModeResult(TransitionUtils.e(f3, f4, f2, 255, 0), 255, false);
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$3, reason: invalid class name */
    public class AnonymousClass3 implements FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public final FadeModeResult a(float f2, float f3, float f4) {
            return new FadeModeResult(TransitionUtils.e(f3, f4, f2, 255, 0), TransitionUtils.e(f3, f4, f2, 0, 255), false);
        }
    }

    /* renamed from: com.google.android.material.transition.platform.FadeModeEvaluators$4, reason: invalid class name */
    public class AnonymousClass4 implements FadeModeEvaluator {
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public final FadeModeResult a(float f2, float f3, float f4) {
            float fA = android.support.v4.media.a.a(f4, f3, 0.35f, f3);
            return new FadeModeResult(TransitionUtils.e(f3, fA, f2, 255, 0), TransitionUtils.e(fA, f4, f2, 0, 255), false);
        }
    }
}
