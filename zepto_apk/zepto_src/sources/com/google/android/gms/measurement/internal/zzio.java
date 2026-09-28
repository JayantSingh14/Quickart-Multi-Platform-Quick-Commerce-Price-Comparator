package com.google.android.gms.measurement.internal;

import androidx.fragment.app.e;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzio implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39133a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzjc f39134b;

    public zzio(zzjc zzjcVar, zzr zzrVar) {
        this.f39133a = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39134b = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        zzjc zzjcVar = this.f39134b;
        zzjcVar.f39177a.A();
        zzpf zzpfVar = zzjcVar.f39177a;
        e.y(zzpfVar);
        zzr zzrVar = this.f39133a;
        Preconditions.checkNotEmpty(zzrVar.f39648a);
        zzpfVar.l0(zzrVar);
        zzpfVar.m0(zzrVar);
    }
}
