package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdpk implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdpm f28173a;

    public zzdpk(zzdpm zzdpmVar) {
        Objects.requireNonNull(zzdpmVar);
        this.f28173a = zzdpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.d6)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("omid native display exp", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        try {
            zzcir zzcirVar = (zzcir) ((List) obj).get(0);
            if (zzcirVar != null) {
                zzdpm zzdpmVar = this.f28173a;
                zzdpmVar.getClass();
                zzdpmVar.f28177c.execute(new zzdpl(zzcirVar));
            }
        } catch (ClassCastException | IndexOutOfBoundsException e2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.d6)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("omid native display exp", e2);
            }
        }
    }
}
