package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class PerformanceTracker {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14199a = false;

    /* renamed from: b, reason: collision with root package name */
    public final ArraySet f14200b = new ArraySet();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f14201c = new HashMap();

    /* renamed from: com.airbnb.lottie.PerformanceTracker$1, reason: invalid class name */
    public class AnonymousClass1 implements Comparator<Pair<String, Float>> {
        @Override // java.util.Comparator
        public final int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = pair.f2990b.floatValue();
            float fFloatValue2 = pair2.f2990b.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    public interface FrameListener {
        void a();
    }

    public final void a(boolean z) {
        this.f14199a = z;
    }
}
