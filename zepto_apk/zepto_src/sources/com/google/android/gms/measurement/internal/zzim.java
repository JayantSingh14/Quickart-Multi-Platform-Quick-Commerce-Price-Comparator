package com.google.android.gms.measurement.internal;

import androidx.fragment.app.e;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzim implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39129a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzjc f39130b;

    public zzim(zzjc zzjcVar, zzr zzrVar) {
        this.f39129a = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39130b = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        zzjc zzjcVar = this.f39130b;
        zzjcVar.f39177a.A();
        zzpf zzpfVar = zzjcVar.f39177a;
        e.y(zzpfVar);
        zzr zzrVar = this.f39129a;
        Preconditions.checkNotEmpty(zzrVar.f39648a);
        zzpfVar.a0(zzrVar);
    }
}
