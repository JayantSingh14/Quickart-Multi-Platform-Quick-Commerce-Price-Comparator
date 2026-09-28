package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzexi implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30527a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f30528b;

    public zzexi(Context context, Intent intent) {
        this.f30527a = context;
        this.f30528b = intent;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        com.google.android.gms.ads.internal.util.zze.k("HsdpMigrationSignal.produce");
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Vd)).booleanValue()) {
            return zzgym.a(new zzexj(null));
        }
        boolean z = false;
        try {
            if (this.f30528b.resolveActivity(this.f30527a.getPackageManager()) != null) {
                com.google.android.gms.ads.internal.util.zze.k("HSDP intent is supported");
                z = true;
            }
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("HsdpMigrationSignal.isHsdpMigrationSupported", e2);
        }
        return zzgym.a(new zzexj(Boolean.valueOf(z)));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 60;
    }
}
