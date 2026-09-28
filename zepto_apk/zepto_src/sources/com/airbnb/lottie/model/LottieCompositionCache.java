package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

@RestrictTo
/* loaded from: classes3.dex */
public class LottieCompositionCache {

    /* renamed from: b, reason: collision with root package name */
    public static final LottieCompositionCache f14469b = new LottieCompositionCache();

    /* renamed from: a, reason: collision with root package name */
    public final LruCache f14470a = new LruCache(20);

    public final LottieComposition a(String str) {
        if (str == null) {
            return null;
        }
        return (LottieComposition) this.f14470a.c(str);
    }
}
