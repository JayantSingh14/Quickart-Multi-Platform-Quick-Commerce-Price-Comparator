package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzms implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39431a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f39432b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbg f39433c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zznk f39434d;

    public zzms(zznk zznkVar, zzr zzrVar, boolean z, zzbg zzbgVar) {
        this.f39431a = zzrVar;
        this.f39432b = z;
        this.f39433c = zzbgVar;
        this.f39434d = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zznk zznkVar = this.f39434d;
        zzga zzgaVar = zznkVar.f39485d;
        if (zzgaVar == null) {
            zzgt zzgtVar = zznkVar.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Discarding data. Failed to send event to service");
        } else {
            zzr zzrVar = this.f39431a;
            Preconditions.checkNotNull(zzrVar);
            zznkVar.y(zzgaVar, this.f39432b ? null : this.f39433c, zzrVar);
            zznkVar.t();
        }
    }
}
