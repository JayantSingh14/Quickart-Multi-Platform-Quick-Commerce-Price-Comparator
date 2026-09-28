package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbly {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.formats.zze f25306a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.formats.zzd f25307b;

    /* renamed from: c, reason: collision with root package name */
    public zzbkt f25308c;

    public zzbly(com.google.android.gms.ads.formats.zze zzeVar, com.google.android.gms.ads.formats.zzd zzdVar) {
        this.f25306a = zzeVar;
        this.f25307b = zzdVar;
    }

    public final zzblf a() {
        return new zzblx(this);
    }

    public final zzblc b() {
        if (this.f25307b == null) {
            return null;
        }
        return new zzblw(this);
    }
}
