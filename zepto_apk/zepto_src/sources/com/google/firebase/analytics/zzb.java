package com.google.firebase.analytics;

import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzb implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAnalytics f43552a;

    public zzb(FirebaseAnalytics firebaseAnalytics) {
        Objects.requireNonNull(firebaseAnalytics);
        this.f43552a = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.f43552a.f43527a.f();
    }
}
