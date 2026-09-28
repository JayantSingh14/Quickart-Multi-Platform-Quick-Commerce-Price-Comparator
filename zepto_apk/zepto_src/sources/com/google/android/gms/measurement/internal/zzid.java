package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzid implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39099a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzjc f39100b;

    public zzid(zzjc zzjcVar, zzr zzrVar) {
        this.f39099a = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39100b = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzjc zzjcVar = this.f39100b;
        zzjcVar.f39177a.A();
        zzjcVar.f39177a.W(this.f39099a);
    }
}
