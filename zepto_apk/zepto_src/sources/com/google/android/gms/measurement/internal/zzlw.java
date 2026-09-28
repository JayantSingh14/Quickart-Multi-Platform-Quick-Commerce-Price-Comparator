package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzlw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzma f39368a;

    public zzlw(zzma zzmaVar) {
        Objects.requireNonNull(zzmaVar);
        this.f39368a = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar = this.f39368a;
        zzmaVar.f39381e = zzmaVar.f39386j;
    }
}
