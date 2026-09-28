package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzit implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzpk f39144a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzr f39145b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzjc f39146c;

    public zzit(zzjc zzjcVar, zzpk zzpkVar, zzr zzrVar) {
        this.f39144a = zzpkVar;
        this.f39145b = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39146c = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        zzjc zzjcVar = this.f39146c;
        zzjcVar.f39177a.A();
        zzpk zzpkVar = this.f39144a;
        Object objB = zzpkVar.b();
        zzr zzrVar = this.f39145b;
        zzpf zzpfVar = zzjcVar.f39177a;
        if (objB == null) {
            zzpfVar.V(zzpkVar.f39627b, zzrVar);
        } else {
            zzpfVar.U(zzpkVar, zzrVar);
        }
    }
}
