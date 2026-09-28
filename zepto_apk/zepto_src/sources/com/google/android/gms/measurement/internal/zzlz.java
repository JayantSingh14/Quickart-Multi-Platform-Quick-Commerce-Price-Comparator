package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzlz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzma f39374a;

    public zzlz(zzma zzmaVar) {
        Objects.requireNonNull(zzmaVar);
        this.f39374a = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39374a.f39386j = null;
    }
}
