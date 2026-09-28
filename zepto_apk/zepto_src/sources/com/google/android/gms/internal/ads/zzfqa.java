package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfqa extends zzfqy {
    @Override // com.google.android.gms.internal.ads.zzfqy
    public final ListenableFuture g(Context context) {
        zzbsz zzbszVar = (zzbsz) this.f31670d.f31269c.get();
        if (zzbszVar == null) {
            return zzgym.b(new zzfpq());
        }
        com.google.android.gms.ads.internal.client.zzbx zzbxVarF2 = this.f31667a.F2(new ObjectWrapper(context), new com.google.android.gms.ads.internal.client.zzr(), this.f31671e.f21239a, zzbszVar, this.f31669c);
        if (zzbxVarF2 == null) {
            return zzgym.b(new zzfpq());
        }
        zzgzf zzgzfVar = new zzgzf();
        try {
            u(this.f31671e.f21241c);
            ((zzeqx) zzbxVarF2).Ga(this.f31671e.f21241c, new zzfpz(this, zzgzfVar, (zzeqx) zzbxVarF2));
            return zzgzfVar;
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to load interstitial ad.", e2);
            return zzgym.b(new zzfpq());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzea h(Object obj) {
        try {
            return ((com.google.android.gms.ads.internal.client.zzbx) obj).f();
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Failed to get response info for  the interstitial ad.", e2);
            return null;
        }
    }
}
