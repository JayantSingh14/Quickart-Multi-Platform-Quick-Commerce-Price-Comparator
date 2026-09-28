package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdks implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdjw f27860a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f27861b;

    public zzdks(zzdjw zzdjwVar, zzijf zzijfVar) {
        this.f27860a = zzdjwVar;
        this.f27861b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Executor executor = (Executor) this.f27861b.zzb();
        final zzcir zzcirVar = this.f27860a.f27834b;
        return new zzdij(new zzdfh() { // from class: com.google.android.gms.internal.ads.zzdju
            @Override // com.google.android.gms.internal.ads.zzdfh
            public final /* synthetic */ void g() {
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZ;
                zzcir zzcirVar2 = zzcirVar;
                if (zzcirVar2 == null || (zzmVarZ = zzcirVar2.z()) == null) {
                    return;
                }
                zzmVarZ.zzb();
            }
        }, executor);
    }
}
