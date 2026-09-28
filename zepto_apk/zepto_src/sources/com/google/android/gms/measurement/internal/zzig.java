package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzig implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzah f39108a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzr f39109b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzjc f39110c;

    public zzig(zzjc zzjcVar, zzah zzahVar, zzr zzrVar) {
        this.f39108a = zzahVar;
        this.f39109b = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39110c = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        zzjc zzjcVar = this.f39110c;
        zzjcVar.f39177a.A();
        zzah zzahVar = this.f39108a;
        Object objB = zzahVar.f38678c.b();
        zzr zzrVar = this.f39109b;
        zzpf zzpfVar = zzjcVar.f39177a;
        if (objB == null) {
            zzpfVar.Y(zzahVar, zzrVar);
        } else {
            zzpfVar.X(zzahVar, zzrVar);
        }
    }
}
