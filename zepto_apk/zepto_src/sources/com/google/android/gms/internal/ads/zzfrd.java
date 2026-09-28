package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfrd extends zzfqy {
    @Override // com.google.android.gms.internal.ads.zzfqy
    public final ListenableFuture g(Context context) {
        zzbsz zzbszVar = (zzbsz) this.f31670d.f31269c.get();
        if (zzbszVar == null) {
            return zzgym.b(new zzfpq());
        }
        zzcaf zzcafVarY2 = this.f31667a.Y2(new ObjectWrapper(context), this.f31671e.f21239a, zzbszVar, this.f31669c);
        if (zzcafVarY2 == null) {
            return zzgym.b(new zzfpq());
        }
        zzgzf zzgzfVar = new zzgzf();
        try {
            u(this.f31671e.f21241c);
            ((zzfhi) zzcafVarY2).I5(this.f31671e.f21241c, new zzfrc(this, zzgzfVar, (zzfhi) zzcafVarY2));
            return zzgzfVar;
        } catch (RemoteException unused) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Failed to load rewarded ad.");
            return zzgym.b(new zzfpq());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfqy
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzea h(Object obj) {
        try {
            return ((zzcaf) obj).zzm();
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Failed to get response info for the rewarded ad.", e2);
            return null;
        }
    }
}
