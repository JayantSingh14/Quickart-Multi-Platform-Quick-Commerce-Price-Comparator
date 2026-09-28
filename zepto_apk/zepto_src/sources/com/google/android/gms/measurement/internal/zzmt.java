package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzmt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39435a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f39436b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzah f39437c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zznk f39438d;

    public zzmt(zznk zznkVar, zzr zzrVar, boolean z, zzah zzahVar) {
        this.f39435a = zzrVar;
        this.f39436b = z;
        this.f39437c = zzahVar;
        Objects.requireNonNull(zznkVar);
        this.f39438d = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zznk zznkVar = this.f39438d;
        zzga zzgaVar = zznkVar.f39485d;
        if (zzgaVar == null) {
            zzgt zzgtVar = zznkVar.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Discarding data. Failed to send conditional user property to service");
        } else {
            zzr zzrVar = this.f39435a;
            Preconditions.checkNotNull(zzrVar);
            zznkVar.y(zzgaVar, this.f39436b ? null : this.f39437c, zzrVar);
            zznkVar.t();
        }
    }
}
