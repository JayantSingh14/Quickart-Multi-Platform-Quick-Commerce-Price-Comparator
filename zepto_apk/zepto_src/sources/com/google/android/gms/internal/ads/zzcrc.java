package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzcrc implements zzdak {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhr f26943a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcdf f26944b;

    public zzcrc(zzfhr zzfhrVar, zzcdf zzcdfVar) {
        this.f26943a = zzfhrVar;
        this.f26944b = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() {
        if (this.f26943a.r0) {
            zzcdf zzcdfVar = this.f26944b;
            synchronized (zzcdfVar.f25962a) {
                zzcdc zzcdcVar = zzcdfVar.f25965d;
                synchronized (zzcdcVar.f25952f) {
                    zzcdcVar.f25958l++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(zzbzj zzbzjVar, String str, String str2) {
    }
}
