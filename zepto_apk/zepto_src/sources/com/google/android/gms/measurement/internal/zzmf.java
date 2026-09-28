package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzmf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39398a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f39399b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzpk f39400c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zznk f39401d;

    public zzmf(zznk zznkVar, zzr zzrVar, boolean z, zzpk zzpkVar) {
        this.f39398a = zzrVar;
        this.f39399b = z;
        this.f39400c = zzpkVar;
        this.f39401d = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zznk zznkVar = this.f39401d;
        zzga zzgaVar = zznkVar.f39485d;
        if (zzgaVar == null) {
            zzgt zzgtVar = zznkVar.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Discarding data. Failed to set user property");
        } else {
            zzr zzrVar = this.f39398a;
            Preconditions.checkNotNull(zzrVar);
            zznkVar.y(zzgaVar, this.f39399b ? null : this.f39400c, zzrVar);
            zznkVar.t();
        }
    }
}
