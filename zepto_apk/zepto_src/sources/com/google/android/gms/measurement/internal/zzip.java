package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzip implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39135a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzjc f39136b;

    public zzip(zzjc zzjcVar, zzr zzrVar) {
        this.f39135a = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39136b = zzjcVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws IOException {
        zzjc zzjcVar = this.f39136b;
        zzjcVar.f39177a.A();
        return new zzao(zzjcVar.f39177a.o0(this.f39135a.f39648a));
    }
}
