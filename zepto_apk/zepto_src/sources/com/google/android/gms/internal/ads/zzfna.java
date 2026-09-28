package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzfna implements zzdhw, zzdba, zzdia {

    /* renamed from: a, reason: collision with root package name */
    public final zzfno f31434a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfne f31435b;

    public zzfna(Context context, zzfno zzfnoVar) {
        this.f31434a = zzfnoVar;
        this.f31435b = zzfne.f(13, context);
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final void c(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbid.f25134d.c()).booleanValue()) {
            String string = zzeVar.b().toString();
            zzfne zzfneVar = this.f31435b;
            zzfneVar.b(string);
            zzfneVar.a(false);
            this.f31434a.a(zzfneVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdia
    public final void g() {
        if (((Boolean) zzbid.f25134d.c()).booleanValue()) {
            zzfne zzfneVar = this.f31435b;
            zzfneVar.a(true);
            this.f31434a.a(zzfneVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdia
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final void zzg() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final void zzh() {
        if (((Boolean) zzbid.f25134d.c()).booleanValue()) {
            this.f31435b.zza();
        }
    }
}
