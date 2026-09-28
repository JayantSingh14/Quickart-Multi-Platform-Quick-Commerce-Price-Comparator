package com.google.firebase.analytics;

import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzc implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAnalytics f43553a;

    public zzc(FirebaseAnalytics firebaseAnalytics) {
        Objects.requireNonNull(firebaseAnalytics);
        this.f43553a = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.f43553a.f43527a.g();
    }
}
